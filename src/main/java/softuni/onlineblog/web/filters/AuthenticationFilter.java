package softuni.onlineblog.web.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import softuni.onlineblog.domain.entities.Role;
import softuni.onlineblog.domain.entities.User;
import softuni.onlineblog.util.Constants;
import softuni.onlineblog.util.jwt.LoginRequestDto;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.Key;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;


public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private AuthenticationManager authenticationManager;


    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/users/login");

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        LoginRequestDto loginRequestDto = null;
        try {
            loginRequestDto = new ObjectMapper().readValue(request.getInputStream(), LoginRequestDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword(), null));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User principal = (User) authResult.getPrincipal();

        Key signingKey = new SecretKeySpec(DatatypeConverter.parseBase64Binary(Constants.JWT_SECRET_KEY), SignatureAlgorithm.HS256.getJcaName());

        String roles = convertRoles(principal.getRoles());

        String jwt = Jwts.builder()
                .setSubject(principal.getUsername()).claim("roles", roles).setExpiration(new Date(System.currentTimeMillis() + 900_000))
                .signWith(signingKey).compact();

        response.getWriter().write(jwt);


    }

    private String convertRoles(Set<Role> roles) {
        return roles.stream().map(Role::getRole).collect(Collectors.joining(","));
    }
}

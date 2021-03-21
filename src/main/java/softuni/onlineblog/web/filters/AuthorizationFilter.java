package softuni.onlineblog.web.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import softuni.onlineblog.util.Constants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;


public class AuthorizationFilter extends BasicAuthenticationFilter {


    public AuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String authorization = request.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer")) {
            chain.doFilter(request, response);
            return;
        }

        authorization = authorization.substring(7);

        UsernamePasswordAuthenticationToken extractedToken = null;

        try {
            extractedToken = extractToken(authorization);
        } catch (ExpiredJwtException ex) {

            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("JWT TOKEN EXPIRED");
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(extractedToken);
        chain.doFilter(request, response);


    }

    private UsernamePasswordAuthenticationToken extractToken(String token) {

        String username = null;


        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(DatatypeConverter
                        .parseBase64Binary(Constants.JWT_SECRET_KEY)).build().parseClaimsJws(token);


        //todo "valeri"
        username = claimsJws.getBody().getSubject().replaceAll("[\"]+", "");

        if (username == null) {
            return null;
        }


        return new UsernamePasswordAuthenticationToken(username, null, null);

    }
}

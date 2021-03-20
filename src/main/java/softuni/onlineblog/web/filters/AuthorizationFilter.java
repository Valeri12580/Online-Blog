package softuni.onlineblog.web.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import softuni.onlineblog.util.Constants;

import javax.crypto.SecretKey;
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

        if(authorization == null || !authorization.startsWith("Bearer")){
            chain.doFilter(request,response);
            return;
        }
        authorization=authorization.substring(7);
        SecurityContextHolder.getContext().setAuthentication(extractToken(authorization));

        System.out.println("authorization filter");


    }

    private UsernamePasswordAuthenticationToken extractToken(String token){

        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(Constants.JWT_SECRET_KEY)).build().parseClaimsJws(token);
        System.out.println(claimsJws.getBody());
        return null;

    }
}

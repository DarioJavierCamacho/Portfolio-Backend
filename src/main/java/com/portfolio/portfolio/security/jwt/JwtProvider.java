package com.portfolio.portfolio.security.jwt;

import com.portfolio.portfolio.security.entity.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 *
 * @author dario Genera el token y lo valida
 */
@Component
public class JwtProvider {

    @Value("$jwt.secret")
    private String secret;
    @Value("$jwt.expiration")
    private int expiration;
    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    public String generateToken(Authentication authentication) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.ES512, secret).compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject(); //subject = username
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e) {
            logger.error("token malformado");
        }catch (UnsupportedJwtException e) {
            logger.error("token no soportado");
        }catch (ExpiredJwtException e) {
            logger.error("token expirado");
        }catch (IllegalArgumentException e) {
            logger.error("token vacio");
        }catch (SignatureException e) {
            logger.error("error en la firma");
        }
        return false;
    }
}
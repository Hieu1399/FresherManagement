package com.vmo.FresherManagement.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.vmo.FresherManagement.*;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {
    private final String JWT_SECRET = "nguyenhuuhieu";
    private final long JWT_EXPIRATION = 604800000L;
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    public String generateToken(CustomUserDetails customUserDetails){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(String.valueOf(customUserDetails.getUser().getUsername()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String getUsernameFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return String.valueOf(claims.getSubject());
    }

    public boolean validateToken(String authToken){
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token", ex);
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token", ex);
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token", ex);
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty", ex);
        }
        return false;
    }
}
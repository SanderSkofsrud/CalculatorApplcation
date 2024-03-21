package org.example.springbootbackend.service;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


/**
 * The type Jwt service.
 */
@Service
public class JWTService {

    private static final String SECRET_KEY = "6A586E3272357538782F413F4428472B4B6250645367566B5970337336763979";
    private final Logger logger = LoggerFactory.getLogger(JWTService.class);


    /**
     * Extract username string.
     *
     * @param token the token
     * @return the string
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }


    /**
     * Extract claim t.
     *
     * @param <T>            the type parameter
     * @param token          the token
     * @param claimsResolver the claims resolver
     * @return the t
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    /**
     * Is token valid boolean.
     *
     * @param token       the token
     * @param userDetails the user details
     * @return the boolean
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


    /**
     * Extract expiration date.
     *
     * @param token the token
     * @return the date
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    /**
     * Generate token string.
     *
     * @param userDetails the user details
     * @return the string
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> extraClaims = new HashMap<>();
        return generateToken(extraClaims, userDetails);
    }


    /**
     * Generate token string.
     *
     * @param extraClaims the extra claims
     * @param userDetails the user details
     * @return the string
     */
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    private Claims extractAllClaims(String token) {
        logger.info("Token being checked: " + token);
        logger.info("Token length: " + token.length());
        try {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            logger.error("Error parsing JWT token: " + e.getMessage());
            throw e;
        }
    }


    private Key getSigningKey() {
        byte[] key = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(key);
    }
}
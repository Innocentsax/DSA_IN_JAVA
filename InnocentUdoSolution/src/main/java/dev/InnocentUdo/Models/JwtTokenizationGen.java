package dev.InnocentUdo.Models;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtTokenizationGen {
    public static String generateToken(String email) {
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + StaticVar.JWT_SECRET_EXPIRATION);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(key())
                .compact();
    }

    private static Key key() {
        byte[] bytes = Decoders.BASE64.decode(StaticVar.JWT_SECRET);
        return Keys.hmacShaKeyFor(bytes);
    }

    public static String validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parseClaimsJws(token);

            return StaticVar.VERIFICATION_PASS_MESSAGE;
        } catch (ExpiredJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            return StaticVar.VERIFICATION_FAILS_MESSAGE;
        }
    }
}


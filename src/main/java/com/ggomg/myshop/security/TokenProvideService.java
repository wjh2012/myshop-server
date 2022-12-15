package com.ggomg.myshop.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class TokenProvideService {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String create(Long memberId) {
        return Jwts.builder()
                .setHeaderParam("type", "jwt")
                .setIssuer("myshop") // 발급자
                .setSubject(String.valueOf(memberId)) //claim 제목
                .signWith(key)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .compact();
    }

    public String validateMember(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}

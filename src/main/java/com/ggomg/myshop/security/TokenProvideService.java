package com.ggomg.myshop.security;

import com.ggomg.myshop.member.entity.Member;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenProvideService {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String create(Long memberId) {
        return Jwts.builder()
                .signWith(key)
                .setSubject(String.valueOf(memberId))
                .setIssuer("GGOMG")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .compact();
    }

    public String validateMember(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}

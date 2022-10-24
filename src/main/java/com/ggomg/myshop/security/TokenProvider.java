package com.ggomg.myshop.security;

import com.ggomg.myshop.member.entity.Member;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.LocalDate;
import java.util.Date;

@Service
public class TokenProvider {
    private static final String SECRET_KEY = "this-is-my-super-ultra-complex-secret-key";
    private static final Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));

    public String create(Member member) {

        return Jwts.builder()
                .signWith(key)
                .setSubject(String.valueOf(member.getId()))
                .setIssuer("GGOMG")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .compact();
    }

    public String validateMember(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .

    }
}

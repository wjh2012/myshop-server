package com.ggomg.myshop.config;

import com.ggomg.myshop.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity // 필터체인 등록
public class WebSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
        );

        // cors
        http.cors();
        // GET 요청을 제외한 POST, PUT, DELETE 요청은 csrf토큰이 있어야 가능
        http.csrf().disable();
        // 팝업로그인
        http.httpBasic().disable();
        // 인증정보를 서버에 담아두지 않는다
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 경로별 설정
        http.authorizeRequests()
                .antMatchers("/", "/signup", "/signin").permitAll();
        http.authorizeRequests()
                .anyRequest().authenticated();

        return http.build();
    }
}

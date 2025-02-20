package com.baseball.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Configuration 등록하기
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록이 된다.
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                // csrf : 주로 SSR인 경우 필요(html 코드를 수정하기 때문이라고 함)
                .csrf(AbstractHttpConfigurer::disable)

                // form 로그인 방식 사용
                .formLogin(form -> form
                        //.loginPage("/login")
                        .defaultSuccessUrl("/admin", true)

                        .permitAll()
                )

                // http 인증방식 미사용으로 disable
                //.httpBasic(AbstractHttpConfigurer::disable)

                // 경로 인증 인가 설정
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/login", "/logout", "/join","/list",
                                "/home", "/list", "/list/2025-1", "/history", "/history/detail",
                                        "/index","admin/game","/img/**").permitAll() // 누구나 경로 허용

                        .requestMatchers("/admin").hasRole("ADMIN") // admin 권한자만 사용
                        .requestMatchers("/my/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated()); // 로그인한 사용자는 가능

        return http.build();
    }

    // 비밀번호 암호화
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

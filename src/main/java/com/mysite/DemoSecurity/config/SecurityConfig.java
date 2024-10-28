package com.mysite.DemoSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	//throws : 예외가 발생할 가능성을 선언 (Exception예외)
        log.info("security config ...");

        http
       		.formLogin(formLogin -> formLogin
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
                )
       		.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/home","/signup").permitAll()
                .anyRequest().authenticated()
                )
       		.logout(logout -> logout
            		.logoutSuccessUrl("/")
            		.permitAll()
            		);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
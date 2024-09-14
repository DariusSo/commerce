package com.GeT.commerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/products").anonymous()
                        .requestMatchers(HttpMethod.GET, "/products/**").anonymous()
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf((csrf -> csrf.disable()));

        return http.build();
    }

}

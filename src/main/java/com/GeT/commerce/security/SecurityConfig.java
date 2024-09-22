package com.GeT.commerce.security;

import com.GeT.commerce.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig {


//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        jdbcUserDetailsManager.setUsersByUsernameQuery("select email, password, status from users WHERE email = ?");
//
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select email, role from authorities where email = ?");
//
//        return jdbcUserDetailsManager;
//    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //authenticationProvider bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/products").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/products/**").anonymous()
                        .requestMatchers(HttpMethod.GET, "/products/category/**").anonymous()
                        .requestMatchers(HttpMethod.GET, "/categories/get").anonymous()
                        .requestMatchers(HttpMethod.PUT, "/users").anonymous()
                        .requestMatchers(HttpMethod.DELETE, "/products/**").hasRole("ADMIN")


        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf((csrf -> csrf.disable()));

        return http.build();
    }


}

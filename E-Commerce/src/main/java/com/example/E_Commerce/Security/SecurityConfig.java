package com.example.E_Commerce.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)  
            .authorizeHttpRequests((request) -> request
                .requestMatchers("/products/**","/category/**","/cart/**")
                .permitAll() 
                .anyRequest()  
                .authenticated()
            )
            .oauth2ResourceServer((auth)-> auth.jwt((jwt)-> jwt.jwtAuthenticationConverter(new TokenConverter())));
            return http.build();
    }

    


}

package com.baas.firebase.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize->authorize.anyRequest().authenticated())
                .oauth2ResourceServer(auth-> auth.jwt(jwtConfigurer -> jwtConfigurer
                        .jwkSetUri("https://www.googleapis.com/service_accounts/v1/jwk/securetoken%40system.gserviceaccount.com")));

        return http.build();
    }



}

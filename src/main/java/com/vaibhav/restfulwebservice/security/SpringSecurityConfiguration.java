package com.vaibhav.restfulwebservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.*;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain createFilterChain(HttpSecurity http) throws Exception {
        //All reqs authenticated
        //If not, show pop up
        //CSRF -> PUT,POST

        http
                .authorizeHttpRequests(
                        (request) -> request
                                .anyRequest()
                                .authenticated())
                .httpBasic(withDefaults())
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}

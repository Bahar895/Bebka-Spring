package com.bahar.Bebka_Spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Şifreleri encode etmek için
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // test için CSRF kapalı
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/").permitAll()   // kullanıcı ekleme/listeleme serbest
                        .requestMatchers("/test/").permitAll()    // test endpointleri serbest
                        .anyRequest().authenticated()               // diğer tüm istekler auth ister
                )
                .httpBasic(basic -> {}); // basic auth kullanımı

        return http.build();
    }
}
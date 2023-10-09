package br.com.fiap.InventarioWeb.config;

import java.security.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Permitir todos os pedidos sem autenticação
        http.authorizeRequests()
            .requestMatchers(HttpMethod.POST, "/api/produtos").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/produtos").permitAll()
            .requestMatchers(HttpMethod.PUT, "/api/produtos").permitAll()
            .requestMatchers(HttpMethod.DELETE, "/api/produtos").permitAll()
            .requestMatchers(HttpMethod.POST, "/api/fornecedor").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/fornecedor").permitAll()
            .requestMatchers(HttpMethod.PUT, "/api/fornecedor").permitAll()
            .requestMatchers(HttpMethod.DELETE, "/api/fornecedor").permitAll()
            .and()
            .csrf()
            .disable();
        
        return http.build();
    }
}


package es.ieslavereda.proyectospringboot2526.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    // =========================
    // SECURITY FILTER CHAIN
    // =========================
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 🔥 IMPORTANTE: usar nuestro CORS explícito
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // CSRF desactivado para API REST
                .csrf(csrf -> csrf.disable())

                // Todas las rutas protegidas
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )

                // Autenticación Basic
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // =========================
    // USUARIO EN MEMORIA
    // =========================
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    // =========================
    // CORS CONFIGURATION
    // =========================
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        // ✔ Frontend permitido
        configuration.setAllowedOrigins(List.of(
                "http://localhost:5500",
                "http://127.0.0.1:5500"
        ));

        // ✔ Métodos permitidos
        configuration.setAllowedMethods(List.of(
                "GET",
                "POST",
                "PUT",
                "DELETE",
                "OPTIONS"
        ));

        // ✔ Headers permitidos
        configuration.setAllowedHeaders(List.of("*"));

        // ✔ IMPORTANTE para tu Basic Auth
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
package lk.ijse.gdse63.aad.vehicleservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JWTAuthFilter jwtAuthFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(jwtAuthFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .requestMatchers("/*").hasAnyAuthority("hotelAdmin","packageAdmin","vehicleAdmin")
                .anyRequest().permitAll()

                .and()
                .csrf().disable();
        return http.build();

    }
}

//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6InZlaGljbGVBZG1pbiIsInN1YiI6InZlaGljbGVOYW1lIiwiaWF0IjoxNjk4OTkwNzM1LCJleHAiOjQ4NTI1OTA3MzV9.4dLNb0hqXzS8ZIja2Kqx4Zn7Ax2kVbypvDe3WGhgEY8
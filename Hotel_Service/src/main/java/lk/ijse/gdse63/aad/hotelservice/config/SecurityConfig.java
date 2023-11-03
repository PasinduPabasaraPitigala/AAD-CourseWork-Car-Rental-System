package lk.ijse.gdse63.aad.hotelservice.config;

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
        http.csrf(csrf -> csrf.disable()).cors(cors->cors.disable())
                .addFilterBefore(jwtAuthFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .requestMatchers("/*").hasAnyAuthority("hotelAdmin","packageAdmin")
                .anyRequest().permitAll();
        return http.build();

    }
}

//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6ImhvdGVsQWRtaW4iLCJzdWIiOiJob3RlbE5hbWUiLCJpYXQiOjE2OTg1Njc2MTAsImV4cCI6NDg1MjE2NzYxMH0.VHug8k4hy1RLuJuG-iSrfCkchy-Fwh0qlJzMzUd2jRA
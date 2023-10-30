package lk.ijse.gdse63.aad.package_detail_service.config;

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
                .requestMatchers("/*").hasAnyAuthority("pdAdmin","pdName")
                .anyRequest().permitAll()

                .and()
                .csrf().disable();
        return http.build();

    }
}

//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6InBkQWRtaW4iLCJzdWIiOiJwZE5hbWUiLCJpYXQiOjE2OTg1NzQyMDQsImV4cCI6NDg1MjE3NDIwNH0.0Qd--jyY5Gtbvsyh6xdHD--07kg0qONTBdwz3cfNX2g
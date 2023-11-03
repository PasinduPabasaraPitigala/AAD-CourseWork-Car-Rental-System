package lk.ijse.gdse63.aad.guideservice.config;


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
                .requestMatchers("/*").hasAnyAuthority("hotelAdmin","packageAdmin","guideAdmin")
                .anyRequest().permitAll()

                .and()
                .csrf().disable();
        return http.build();

    }



}
//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6Imd1aWRlQWRtaW4iLCJzdWIiOiJndWlkZU5hbWUiLCJpYXQiOjE2OTg1NjYzMzAsImV4cCI6NDg1MjE2NjMzMH0.DhRfvi-bdHVssIdn8379x9JOO9Cfzgn1tRp7eHiKogg
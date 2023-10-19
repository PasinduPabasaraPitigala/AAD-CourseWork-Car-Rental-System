package lk.ijse.gdse63.aad.vehicleservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

package lk.ijse.gdse63.aad.user_authorized_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserAuthorizedServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthorizedServiceApplication.class, args);
    }

}

package lk.ijse.gdse63.aad.serviceregister;

import org.glassfish.jaxb.runtime.v2.runtime.output.SAXOutput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegisterApplication.class, args);
        System.out.println("Sever_Registry....");
    }

}

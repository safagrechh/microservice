package tn.esprit.discord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DiscordApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscordApplication.class, args);
    }

}

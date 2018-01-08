package pl.annaczeczek.millionaires;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Millionaires {

    public static void main(String[] args) {
        SpringApplication.run(Millionaires.class, args);
    }

}

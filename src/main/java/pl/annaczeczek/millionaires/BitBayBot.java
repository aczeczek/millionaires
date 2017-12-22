package pl.annaczeczek.millionaires;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BitBayBot {

    public static void main(String[] args) {
        SpringApplication.run(BitBayBot.class, args);
    }
}

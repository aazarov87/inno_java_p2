package ru.inno.edu.task5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.inno.edu.task5")
public class StartRestApp {

    public static void main(String[] args) {
        SpringApplication.run(StartRestApp.class, args);
    }

}

package ru.inno.edu.task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.inno.edu.task4.controller.MigrationMaker;

@SpringBootApplication(scanBasePackages = "ru.inno.edu.task4")
    public class StartMigr implements CommandLineRunner {
    @Autowired
    MigrationMaker migrationMaker;

    public static void main(String[] args) {
            SpringApplication.run(StartMigr.class, args);
        }

        @Override
        public void run(String... args) throws Exception {

            migrationMaker.make();
        }
    }


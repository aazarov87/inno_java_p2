package ru.inno.edu.exampleJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.inno.edu.calcWithSpring.OperationMaker;
import ru.inno.edu.task4.MigrationMaker;

//@SpringBootApplication(scanBasePackages = "ru.inno.edu.exampleJpa")
public class Starter {

    public static void main(String[] args) {
        //ApplicationContext ctx = SpringApplication.run(Starter.class);

        new AnnotationConfigApplicationContext("ru.inno.edu.exampleJpa");
                //.getBean("testComponent", TestComponent.class)
               // .meth();

    }
}

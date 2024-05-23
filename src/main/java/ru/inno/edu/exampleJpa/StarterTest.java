package ru.inno.edu.exampleJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
//@ConfigurationPropertiesScan
public class StarterTest implements CommandLineRunner {
    @Autowired
    TestRepo testRepo;
    public static void main(String[] args) {
        //ApplicationContext ctx =
        SpringApplication.run(StarterTest.class, args);

        //new AnnotationConfigApplicationContext("ru.inno.edu.exampleJpa")
         //       .getBean("starterTest", StarterTest.class);
               // .meth();

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("testRepo = " + testRepo);

        Users users = new Users("exampleJpa");
        testRepo.save(users);
    }
}

package ru.inno.edu.task4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Start {

    public static void main(String[] args) {
      //  List<DataModel> list = new DataReader().get();

        new AnnotationConfigApplicationContext("ru.inno.edu.task4").getBean("migrationMaker", MigrationMaker.class)
                .make();
    }
}

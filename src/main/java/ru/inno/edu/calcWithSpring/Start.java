package ru.inno.edu.calcWithSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext("ru.inno")
                .getBean("operationMaker", OperationMaker.class)
                .make();
    }
}

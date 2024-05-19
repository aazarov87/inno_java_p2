package ru.inno.edu.calcWithSpring;

import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class Printer implements Consumer<Model> {
    @Override
    public void accept(Model model) {
        System.out.println("res = " + model.res);
    }
}

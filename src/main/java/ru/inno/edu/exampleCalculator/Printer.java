package ru.inno.edu.exampleCalculator;

import java.util.function.Consumer;

@Component
public class Printer implements Consumer<Model> {
    @Override
    public void accept(Model model) {
        System.out.println("res = " + model.res);
    }
}

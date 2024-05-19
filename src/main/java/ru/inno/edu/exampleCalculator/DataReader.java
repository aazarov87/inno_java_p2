package ru.inno.edu.exampleCalculator;

import java.util.Scanner;
import java.util.function.Supplier;

@Component
public class DataReader implements java.util.function.Supplier {
    @Override
    public Model get() {
        Scanner sc = new Scanner(System.in);
        //String operation = sc.next();

        Model model = new Model();
        model.op = sc.next();
        model.x = sc.nextInt();
        model.y = sc.nextInt();

        return model;
    }
}

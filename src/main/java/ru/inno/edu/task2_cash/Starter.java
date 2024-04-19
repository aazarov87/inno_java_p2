package ru.inno.edu.task2_cash;

import ru.inno.edu.task2_cash.farction.Fraction;
import ru.inno.edu.task2_cash.farction.Fractionable;
import ru.inno.edu.task2_cash.utils.Utils;

public class Starter {

    public static void main(String... args) {
        Fraction fr= new Fraction(2,3);
        Fractionable num = Utils.cashe(fr);

        System.out.println("1 "+ num.doubleValue());// sout сработал
        System.out.println("2 "+ num.doubleValue());// sout молчит
        System.out.println("3 "+ num.doubleValue());// sout молчит
        System.out.println("4 "+ num.doubleValue());// sout молчит
        num.setNum(5);
        System.out.println("5 "+ num.doubleValue());// sout сработал
        System.out.println("6 "+ num.doubleValue());// sout молчит
        System.out.println("7 "+ num.doubleValue());// sout молчит

        Fractionable fractionable = new Fraction(5,7);
        Fractionable num1 = Utils.cashe(fractionable);
        num1.doubleValue();// sout сработал
        num1.doubleValue();// sout молчит
    }

}

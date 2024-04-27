package ru.inno.edu.task3;

import ru.inno.edu.task3.farction.Fraction;
import ru.inno.edu.task3.farction.Fractionable;
import ru.inno.edu.task3.utils.Utils;


public class Starter {

    public static void main(String... args) throws Throwable {
        Fraction fr= new Fraction(1,2);
        Fractionable num = Utils.cashe(fr);

        System.out.println("1 "+ num.doubleValue());// sout сработал
        System.out.println("2 "+ num.doubleValue());// sout молчит

        Thread.sleep(3000);

        System.out.println("3 "+ num.doubleValue());// sout молчит
        Thread.sleep(1000);
        System.out.println("4 "+ num.doubleValue());// sout молчит
    }

}

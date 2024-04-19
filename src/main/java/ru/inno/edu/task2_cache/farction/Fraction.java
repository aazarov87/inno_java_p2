package ru.inno.edu.task2_cache.farction;

import ru.inno.edu.task2_cache.annotation.Cache;
import ru.inno.edu.task2_cache.annotation.Mutator;

public class Fraction implements Fractionable{

    private int num;
    private int denum;

    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }

    @Mutator
    public void setNum(int num) {
        this.num = num;
    }

    @Mutator
    public void setDenum(int denum) {
        if (denum == 0) throw new IllegalArgumentException("denum is own!!!");
        this.denum = denum;
    }

    @Override
    @Cache
    public double doubleValue() {
        System.out.println(this + " Fraction double value");
        return (double) num/denum;
    }

    @Override
    public String toString() {
       // System.out.println("toString ");
        return "Fraction{" +
                "num=" + num +
                ", denum=" + denum +
                '}';
    }
}

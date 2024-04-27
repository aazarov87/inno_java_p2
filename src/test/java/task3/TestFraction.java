package task3;

import ru.inno.edu.task3.annotation.Cache;
import ru.inno.edu.task3.annotation.Mutator;

public class TestFraction implements TestFractionable {

    private int num;
    private int denum;

    int countdoubleValue = 0;
    int countdoubleValueSqrt = 0;

    public TestFraction(int num, int denum) {
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
    @Cache(timeCache = 2000)
    public double doubleValue() {
        System.out.println(this + " Fraction double value");
        countdoubleValue++;
        return (double) num/denum;
    }

    @Override
    @Cache(timeCache = 4000)
    public double sqrtFraction() {
        countdoubleValueSqrt++;
        System.out.println(this + " Fraction doubleValueSqrt");
        return Math.sqrt((double) num/denum);
    }

    @Override
    @Cache(timeCache = 2000)
    public String toString() {
        System.out.println("toString ");
        return "Fraction{" +
                "num=" + num +
                ", denum=" + denum +
                '}';
    }


}

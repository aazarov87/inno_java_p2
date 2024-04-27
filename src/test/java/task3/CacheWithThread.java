package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.inno.edu.task3.utils.Utils;

public class CacheWithThread {

    @Test
    @DisplayName("cache возвращает правильное значение до вызова Mutator")
    public void TestCacheValue(){
        TestFraction fr= new TestFraction(2,3);

        double valueFr = fr.doubleValue();

        TestFractionable num = Utils.cashe(fr);
        num.doubleValue();
        Assertions.assertEquals(valueFr, num.doubleValue());
    };

    @Test
    @DisplayName("cache возвращает правильное значение после вызова Mutator")
    public void TestCacheValueAfterMutator(){
        TestFraction fr= new TestFraction(2,3);

        TestFractionable num = Utils.cashe(fr);

        num.doubleValue();
        num.setNum(5);
        num.doubleValue();

        Assertions.assertEquals(fr.doubleValue(), num.doubleValue());
    };

    @Test
    @DisplayName("Количества обращений к методу после сброса cache")
    public void TestCacheValueBeforeClearCash() throws InterruptedException {
        TestFraction fr= new TestFraction(2,3);

        TestFractionable num = Utils.cashe(fr);

        num.doubleValue();
        num.doubleValue();
        num.doubleValue();

        Thread.sleep(3000);
        num.doubleValue();

        Assertions.assertEquals(fr.countdoubleValue, 2);
    };

    @Test
    @DisplayName("Проверка, количества обращений к методу до сброса cache, с задержкой")
    public void TestCacheValueBeforeClearCash2() throws InterruptedException {
        TestFraction fr= new TestFraction(2,3);

        TestFractionable num = Utils.cashe(fr);

        num.doubleValue();
        num.doubleValue();
        num.doubleValue();

        Thread.sleep(1000);
        num.doubleValue();

        Assertions.assertEquals(fr.countdoubleValue, 1);
    };


    @Test
    @DisplayName("2 Объекта. 2 метода в кеш с разным значением @Cache. проверка значения второго после сброса первого")
    public void TestCache2Methods2Object() throws InterruptedException {
        TestFraction fr= new TestFraction(2,3);
        TestFraction fr1= new TestFraction(5,6);

        TestFractionable num = Utils.cashe(fr);
        TestFractionable num1 = Utils.cashe(fr1);

        num.doubleValue();
        num1.sqrtFraction();
        num.doubleValue();
        num1.sqrtFraction();

        Thread.sleep(1000);

        Assertions.assertEquals(0.9128709291752769, num1.sqrtFraction());
    };

    @Test
    @DisplayName("2 Объекта. 2 метода в кеш с разным значением @Cache. проверка количества обращений ко второму после сброса первого =1")
    public void TestCache2Methods2Object1() throws InterruptedException {
        TestFraction fr= new TestFraction(2,3);
        TestFraction fr1= new TestFraction(5,6);

        TestFractionable num = Utils.cashe(fr);
        TestFractionable num1 = Utils.cashe(fr1);

        num.doubleValue();
        num1.sqrtFraction();
        num.doubleValue();
        num1.sqrtFraction();

        Thread.sleep(2000);

        num.doubleValue();
        num1.sqrtFraction();

        Assertions.assertEquals(1, fr1.countdoubleValueSqrt);
    };

    @Test
    @DisplayName("2 Объекта. 2 метода в кеш с разным значением @Cache. проверка количества обращений ко второму после сброса первого =2")
    public void TestCache2Methods2Object2() throws InterruptedException {
        TestFraction fr= new TestFraction(2,3);
        TestFraction fr1= new TestFraction(5,6);

        TestFractionable num = Utils.cashe(fr);
        TestFractionable num1 = Utils.cashe(fr1);

        num.doubleValue();
        num1.sqrtFraction();
        num.doubleValue();
        num1.sqrtFraction();

        Thread.sleep(5000);

        num.doubleValue();
        num1.sqrtFraction();

        Assertions.assertEquals(2, fr1.countdoubleValueSqrt);
    };

    @Test
    @DisplayName(" 1 Объект. 2 метода в кеш с разным значением @Cache. проверка значения второго после сброса первого")
    public void TestCache2Methods1Object() throws InterruptedException {
        TestFraction fr= new TestFraction(2,3);

        TestFractionable num = Utils.cashe(fr);

        num.doubleValue();
        num.doubleValue();
        num.sqrtFraction();

        Thread.sleep(1000);

        Assertions.assertEquals(0.816496580927726, num.sqrtFraction());
    };

    @Test
    @DisplayName(" 1 Объект. 2 метода в кеш с разным значением @Cache. проверка количества обращений ко второму после сброса первого = 1")
    public void TestCache2Methods1Object1() throws InterruptedException {
        TestFraction fr= new TestFraction(2,3);

        TestFractionable num = Utils.cashe(fr);

        num.doubleValue();
        num.sqrtFraction();
        num.doubleValue();
        num.sqrtFraction();

        Thread.sleep(2000);

        num.doubleValue();
        num.sqrtFraction();

        Assertions.assertEquals(1, fr.countdoubleValueSqrt);
    };

    @Test
    @DisplayName(" 1 Объект. 2 метода в кеш с разным значением @Cache. проверка количества обращений ко второму после сброса первого = 2")
    public void TestCache2Methods1Object2() throws InterruptedException {
        TestFraction fr= new TestFraction(2,3);

        TestFractionable num = Utils.cashe(fr);

        num.doubleValue();
        num.sqrtFraction();
        num.doubleValue();
        num.sqrtFraction();

        Thread.sleep(5000);

        num.doubleValue();
        num.sqrtFraction();

        Assertions.assertEquals(2, fr.countdoubleValueSqrt);
    };

}

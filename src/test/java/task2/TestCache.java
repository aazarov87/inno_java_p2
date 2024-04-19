package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.inno.edu.task2_cache.farction.Fraction;
import ru.inno.edu.task2_cache.farction.Fractionable;
import ru.inno.edu.task2_cache.utils.Utils;

import java.lang.reflect.Field;

public class TestCache {

    @Test
    @DisplayName("Проверка, что cache возвращает правильное значение до вызова Mutator")
    public void TestCacheValue(){
        Fraction fr= new Fraction(2,3);

        double valueFr = fr.doubleValue();

        Fractionable num = Utils.cashe(fr);
        num.doubleValue();
        Assertions.assertEquals(valueFr, num.doubleValue());
    };

    @Test
    @DisplayName("Проверка, что cache возвращает правильное значение после вызова Mutator")
    public void TestCacheValueAfterMutator(){
        Fraction fr= new Fraction(2,3);

        Fractionable num = Utils.cashe(fr);

        num.doubleValue();
        num.setNum(5);
        num.doubleValue();

        Assertions.assertEquals(fr.doubleValue(), num.doubleValue());
    };

    @Test
    @DisplayName("Проверка, что если изменить знаение через reflection т.е. без Mutator, то Cache возвращает старое значение и не сбрасытавается")
    public void TestCacheValueWithoutMutator() throws IllegalAccessException {
        Fraction fr= new Fraction(2,3);
        double valueFr = fr.doubleValue();

        Fractionable num = Utils.cashe(fr);

        num.doubleValue();

        for (Field declaredField : fr.getClass().getDeclaredFields()) {
            if (declaredField.getName().equals("num")) {
                declaredField.setAccessible(true);
                declaredField.set(fr, 10);
            }
        }

        System.out.println("fr = " + fr);
        System.out.println("first value = " + valueFr);
        System.out.println("value from cache = " + num.doubleValue());
        System.out.println("current value from object = " + num.doubleValue());

        Assertions.assertEquals(valueFr, num.doubleValue());
    };

    @Test
    @DisplayName("Проверка, количество обращений к методу, если он помечен Cache. Через вспомогательный класс")
    public void TestCacheCounter(){
        final int etalonCounter = 1;

        HandlerClass handlerClass = new HandlerClass("test");

        Handlerable able = Utils.cashe(handlerClass);

        able.getName();
        able.getName();
        able.getName();

        Assertions.assertEquals(handlerClass.getCounter(), etalonCounter);
    };
}

package ru.inno.edu.task3.utils;

import java.lang.reflect.Proxy;

public class Utils {

    public static <T> T cashe (T objectIncome){
        return (T) Proxy.newProxyInstance(
                objectIncome.getClass().getClassLoader(),
                objectIncome.getClass().getInterfaces(),
                new Invocation(objectIncome));
    }
}

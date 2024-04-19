package ru.inno.edu.task2_cache.utils;

import ru.inno.edu.task2_cache.annotation.Cache;
import ru.inno.edu.task2_cache.annotation.Mutator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Invocation implements InvocationHandler {

    private static Object obj;

    private Map<Method, Object> cacheValues = new HashMap();

    public <T> Invocation(T objectIncome) {
        obj = objectIncome;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //получаем метод класса по методу интерфейса
        Method methodClass = obj.getClass().getMethod(method.getName(), method.getParameterTypes());

        Object res;

        if ((methodClass.isAnnotationPresent(Cache.class))) {
            if (cacheValues.containsKey(methodClass))  return cacheValues.get(methodClass);

            res= method.invoke(obj, args);
            cacheValues.put(methodClass, res);

            return res;
        }

        if (methodClass.isAnnotationPresent(Mutator.class)) {
            cacheValues.clear();
        }

        res= method.invoke(obj, args);
        return res;
    }
}

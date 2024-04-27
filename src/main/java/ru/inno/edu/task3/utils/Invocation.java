package ru.inno.edu.task3.utils;

import ru.inno.edu.task3.annotation.Cache;
import ru.inno.edu.task3.annotation.Mutator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Invocation<T> implements InvocationHandler {

    private Object obj;

    private List listParamsMethodWithMutator = new ArrayList<>();

    // мапа со списком методов и временем их последнего обновления
    private Map<Method, Date> mapDateUpdateMethod = new HashMap<>();

    public ConcurrentHashMap<Method, Map<CacheValuesHandler, Object>> getCacheValues() {
        return new ConcurrentHashMap<>(cacheValues);
    }

    public void setCacheValues(Map<Method, Map<CacheValuesHandler, Object>> cacheValues) {
        this.cacheValues = cacheValues;
    }

    // поток для всех объектов
    static Thread threadClear;

    // map: keys - метод, values - map:
    // keys - лист значений состояний объетка, values - рассчитанное значение для состояний
    private Map<Method, Map<CacheValuesHandler, Object>> cacheValues = new ConcurrentHashMap<>();

    public <T> Invocation(T objectIncome) {

        obj = objectIncome;

        // т.к. приняли решение, что параметр метода изменяет такое же поле, то наберем список возможных параметров методов с аннотацией @Mutator
        // дальше по ней будем проверять какие состояния объекта использовать как ключ для кеш
        for (Method method: obj.getClass().getDeclaredMethods()
             ) {
            if (method.isAnnotationPresent(Mutator.class)) {
                for (Parameter parameters : method.getParameters()) {
                    listParamsMethodWithMutator.add(parameters.getName());
                }
            }
        }
    }

    public Map<Method, Date> getMapDateUpdateMethod() {
        return new HashMap<>(mapDateUpdateMethod);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //получаем метод класса по методу интерфейса
        Method methodClass = obj.getClass().getMethod(method.getName(), method.getParameterTypes());

        Object res;

        if ((methodClass.isAnnotationPresent(Cache.class))) {

            // если не пускали поток, делаем
            if (Invocation.threadClear == null){
                Invocation.threadClear = new Thread(new ClearCashe());
                System.out.println("активируем поток");
                Invocation.threadClear.setDaemon(true);
                Invocation.threadClear.start();
            }

            List<Object> listKeys = new ArrayList<>();
            Map<CacheValuesHandler, Object> mapObjVsParam = new ConcurrentHashMap<>();

            for (Field declaredField : obj.getClass().getDeclaredFields()) {
                declaredField.setAccessible(true);
                if (listParamsMethodWithMutator.contains(declaredField.getName()))
                    listKeys.add(declaredField.get(obj));
            }

            // if (cacheValues.containsKey(methodClass)) не отрабатывает корректо для разных методов
            for (Method key : cacheValues.keySet()) {
                if (key.equals(methodClass)) {
                    mapObjVsParam = cacheValues.get(methodClass);
                }
            }

            mapDateUpdateMethod.put(methodClass, new Date());

            CacheValuesHandler cacheValuesHandler = new CacheValuesHandler(listKeys);

            if (mapObjVsParam.containsKey(cacheValuesHandler)) {
                return mapObjVsParam.get(cacheValuesHandler);
            }

            res= method.invoke(obj, args);

            mapObjVsParam.put(cacheValuesHandler, res);
            cacheValues.put(methodClass, mapObjVsParam);

            ClearCashe.list.add(this);

            return res;
        }

        res= method.invoke(obj, args);

        return res;
    }

    @Override
    public String toString() {
        return "Invocation{" +
                "obj=" + obj +
                '}';
    }
}


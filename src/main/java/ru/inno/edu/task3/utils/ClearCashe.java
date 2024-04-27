package ru.inno.edu.task3.utils;

import ru.inno.edu.task3.annotation.Cache;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClearCashe implements Runnable {

    public static List<Invocation> list = new ArrayList();

    // лист объектов Invocation
    public ClearCashe() {
        list = new ArrayList<>();
    }

    @Override
    public void run() {

        for (int i =0; i < 30; i++ ) {
            Date date = new Date();

            // Неуспешная попытка оформить проход по мапам не через for ().... ниже сделал как получилось
           /* list.forEach((l) -> l.getCacheValues()
                    .forEach((key, value) -> {
                                System.out.println(key);
                                l.getMapDateUpdateMethod().forEach((dateKey, dateValue) ->
                                {
                                    System.out.println("key = " + key + " dateKey = " + dateKey + " dateValue = " + dateValue);
                                });
                            }
                    )
            );
*/
            // Проверяем мапу каждого добавленного объекта и время изменения кеш для каждого метода. Чистим при необходимости
            for (Invocation invocation: list) {
                ConcurrentHashMap<Method, Map<CacheValuesHandler, Object>> cache = invocation.getCacheValues();

                for (Method key : cache.keySet()) {
                    Map<Method, Date> methodDateMap = invocation.getMapDateUpdateMethod();
                    if (methodDateMap.containsKey(key) && (date.getTime() - methodDateMap.get(key).getTime()) > key.getAnnotation(Cache.class).timeCache())
                    {
                        cache.get(key).clear();
                        invocation.setCacheValues(cache);
                    }

                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

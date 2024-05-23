package ru.inno.edu.task4.Utils;


import ru.inno.edu.task4.annotation.LogTransformation;

import java.io.FileWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;


public class InvocationHandl implements InvocationHandler {

    Object bean;

    public InvocationHandl(Object objectIncome) {
        bean = objectIncome;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method methodClass = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
        if (methodClass.isAnnotationPresent(LogTransformation.class)) {
            String argsInput = Arrays.toString(args);
            Object res = method.invoke(bean, args);

            FileWriter writer = new FileWriter("src/main/resources/log/" + methodClass.getAnnotation(LogTransformation.class).lodFileName(), true);
            writer.write("\n[\n "
                    + "DateExec : " + new Date()
                    + "\n Call class : " + bean.getClass()
                    + "\n DataInput : " +  argsInput
                    + "\n DataOutput : " + res
                    + "\n]"
            );
            writer.close();
            return res;
        }

        return method.invoke(bean, args);
    }
}

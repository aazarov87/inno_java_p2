package ru.inno.edu.task4.Utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.inno.edu.task4.Utils.InvocationHandl;
import ru.inno.edu.task4.annotation.LogTransformation;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class LogTrasformationBeanPostprocessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        for (Method declaredMethod : bean.getClass().getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(LogTransformation.class))
            {
                return Proxy.newProxyInstance(
                        bean.getClass().getClassLoader(),
                        bean.getClass().getInterfaces(),
                        new InvocationHandl(bean)
                );
            }
        }

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}

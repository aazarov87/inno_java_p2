package ru.inno.edu.exampleCalculator;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ObjectComposer {
    private Map<String, Object> objects= new HashMap<>();

    public ObjectComposer(String packageName) {

        try {
            String filePackageName = '/' + packageName.replace('.', '/');
            System.out.println("filePackageName = " + filePackageName);
            File f = new File("src\\main\\java" + filePackageName);
            System.out.println("f = " + f);

            System.out.println("1 " + f.length() +  " " +f.listFiles());
            for (File file : f.listFiles()) {
                System.out.println("2");
               // if (!file.getName().endsWith("class")) continue; // с расширенийм class не берем
                System.out.println("3");
                String clzName = file.getName().split("\\.")[0]; // взли имя до точки
                System.out.println("4");
                Class clz = Class.forName(packageName + "." + clzName);
                System.out.println("5");
                if (!clz.isAnnotationPresent(Component.class)) continue;
                System.out.println("Добавляем мапу = " + clzName);
                objects.put(clzName, clz.newInstance());
            }
        } catch (Exception e){
            System.out.println(e);
            throw new IllegalArgumentException(e);
        }
    }

    public Object getObjectByName(String name){
        return objects.get(name);
    }

    public <T> T getObjectByNameAndType(String name, Class<T> clz) {
        return (T)objects.get(name);
    }


}

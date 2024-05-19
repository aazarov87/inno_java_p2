package ru.inno.edu.exampleCalculator;

import java.io.File;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) throws ClassNotFoundException {
        //обычное решение
        /*Scanner sc = new Scanner(System.in);
        String operation = sc.next();

        int x = sc.nextInt();
        int y = sc.nextInt();
        int res = 0;

        switch (operation) {
            case "+" :res = x + y; break;
            case "-" :res = x - y; break;
            case "*" :res = x * y; break;
            case "/" :res = x / y; break;

        }

        System.out.println("res = " + res);*/

        // решение по принципам SOLID - гибкая архетиктура вставляем интерфейсы
        /*OperationMaker operationMaker = new OperationMaker();
        operationMaker.datareader = new DataReader();
        operationMaker.operations.put("+", new PlusOperation());
        operationMaker.printer = new Printer();
        operationMaker.make();

*/

        // имитация работы Spring
        // создаем аннотацию Component
        // Помечаем ей класс OperationMaker
        //Printer
        //PlusOperation
        //DataReader
        // реализуем класс class ObjectComposer конструктор которого будет компоновать все классы помеченные компоненотой в нужном каталогп
        // Т.е. будет пробегать по классам и помещать их объекты в переменную мапу  - ключ название класса с маленьклй буквы, значение  - сохданный объект
        //

       /* File folder = new File("ru.inno.edu.exampleCalculator").getAbsoluteFile(); // src\main\java\ru\inno\edu
        System.out.println(folder);
       // File[] listOfFiles = folder.listFiles();

        String packageName = "src.main.java.ru.inno.edu.exampleCalculator";
        String filePackageName = '/' + packageName.replace('.', '/');
        System.out.println("filePackageName = " + filePackageName);
        File f = new File("." + filePackageName);

        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
*/
        Class clz = Class.forName("ru.inno.edu.exampleCalculator.Component");
        System.out.println("clz = " + clz);
        // создали мапу объектов
        new ObjectComposer("ru.inno.edu.exampleCalculator") //target\classes\ru\inno\edu
                .getObjectByNameAndType("OperationMaker", OperationMaker.class)
                .make();


    }
}

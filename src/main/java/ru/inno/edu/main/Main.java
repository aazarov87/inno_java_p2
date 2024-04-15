package ru.inno.edu.main;

import ru.inno.edu.check.RuleNameAcc;
import ru.inno.edu.enumCur.Currancy;

public class Main {
    public static void main(String[] args) {

        // сделал передачу правил проверки через класс и лямбда для тренировки))
        Account account = new Account("1Name", new RuleNameAcc(), count -> count<0);

        AccSave accSave = account.getSave();
        System.out.println("accSave = "+ accSave);

        System.out.println("account " + account);

        account.addCurrancy(Currancy.RUB, 200);
        System.out.println("account " + account);

        account.setName("2Name");
        System.out.println("account " + account);

        account.setName("3Name");
        System.out.println("account " + account);

        account.addCurrancy(Currancy.RUB, 500);
        System.out.println("account " + account);

        account.addCurrancy(Currancy.EUR, 100);

        System.out.println("account " + account);
        System.out.println("accSave = "+ accSave);

        account.setName("4Name");
        System.out.println("account " + account);

        account.setName("5Name");
        System.out.println("account " + account);
        System.out.println("accSave = "+ accSave);

        System.out.println("------------------------------------");
        account.undo();
        account.undo();
        account.undo();
        account.undo();
        account.undo();
        account.undo();
        account.undo();
        account.undo();
    }
}

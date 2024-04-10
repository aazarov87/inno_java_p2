package ru.inno.edu;

import ru.inno.edu.check.RuleNameAcc;
import ru.inno.edu.enumCur.Currancy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Account account = new Account("Main", new RuleNameAcc(), count -> count<0);

        account.addCurrancy(Currancy.RUB, 2);

        System.out.println(account);

        account.addCurrancy(Currancy.RUB, 6);

        System.out.println(account);

        Account account1 = new Account("", name -> (name == null || name.isEmpty())/*new RuleNameAcc()*/, count -> count>-1);
    }
}

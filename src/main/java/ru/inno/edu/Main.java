package ru.inno.edu;

import ru.inno.edu.check.RuleNameAcc;
import ru.inno.edu.enumCur.Currancy;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Account account = new Account("Main", new RuleNameAcc(), count -> count<0);

        /*System.out.println("account " + account);

        Account accClone = (Account) account.clone();

        account.addCurrancy(Currancy.RUB, 2);
        System.out.println("account " + account);
        System.out.println("accClone " + accClone);*/
        System.out.println("1 =" + account);
        account.addCurrancy(Currancy.RUB, 2);

        System.out.println("2 =" + account);

        account.setName("piuuu");
        System.out.println("3 =" + account);

        account.addCurrancy(Currancy.RUB, 6);

        System.out.println("4 =" + account);

        account.addCurrancy(Currancy.EUR, 10);


        System.out.println("5 =" + account);


        account = account.undo();

        System.out.println(account);

        account = account.undo();

        System.out.println(account);

        account = account.undo();

        System.out.println(account);

        account = account.undo();

        System.out.println(account);
        account = account.undo();

        System.out.println(account);

        /*account = account.undo();

        System.out.println(account);*/

       // Account account1 = new Account("", name -> (name == null || name.isEmpty())/*new RuleNameAcc()*/, count -> count>-1);


    }
}

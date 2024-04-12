package ru.inno.edu;

import ru.inno.edu.enumCur.Currancy;
import ru.inno.edu.interfaceAcc.RuleCountCur;
import ru.inno.edu.interfaceAcc.RuleNameAcc;

import java.util.*;

public class Account implements Cloneable {

    private String name;
    private HashMap<Currancy, Integer> countCurrancy;

    private RuleCountCur ruleCountCur;

    //private Stack<Account> historyAcc = new Stack<>();
    private List<Account> historyAcc = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.addHistory();

        this.name = name;
    }

    public Account(String name, RuleNameAcc ruleNameAcc, RuleCountCur ruleCountCur) {
        if (ruleNameAcc.checkName(name)) throw new IllegalArgumentException("name is null. Put name");
        this.name = name;
        this.ruleCountCur = ruleCountCur;

        countCurrancy = new HashMap<>();

        //this.addHistory();
    }

    public HashMap<Currancy, Integer> getCountCurrancy() {
        return new HashMap<>(countCurrancy);
    }

    public void addCurrancy(Currancy currancy, int count){
       // System.out.println(currancy +" "+ count)
        this.addHistory();

        if (this.ruleCountCur.check(count)) throw  new IllegalArgumentException("count acc must be >0");
        this.countCurrancy.put(currancy, count);

        /*System.out.println("a1_________________________________V");
        for (Account acc1: historyAcc
        ) {
            System.out.println("this historyAcc" + acc1);
        }
        System.out.println("a1_________________________________^");*/

        //historyAcc.add(this);

       // System.out.println("this countCurrancy=  " + countCurrancy);
       // System.out.println("historyAcc = " + historyAcc);
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", countCurrancy=" + countCurrancy +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Account accTemp = (Account) super.clone();

        System.out.println("clone");
        /*if (this.countCurrancy.isEmpty())*/ accTemp.countCurrancy = new HashMap<>();
        /*else*/ accTemp.countCurrancy = (HashMap<Currancy, Integer>) countCurrancy.clone();
        return accTemp;//super.clone();
    }

    public Account undo(){
        /*System.out.println("u_________________________________V");
        for (Account acc: historyAcc
             ) {
            System.out.println("historyAcc" + acc);
        }
        System.out.println("u_________________________________^");*/

        if (historyAcc.isEmpty()) throw new NoSuchElementException("history state is empty");

        //System.out.println("historyAcc.size() = " + historyAcc.size());

        Account acc = historyAcc.get(historyAcc.size()-1);
        System.out.println("берем предыдущий = " + acc);

        historyAcc.remove(historyAcc.size()-1);
        //this = acc;

       // System.out.println("undo = " + acc);

        return acc;
    }

    public Account getSave (){
        Account acc = null;
        try {
            acc = (Account) this.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        return acc;
    }

    private void addHistory(){
        try {
            //Account acc = (Account) this.clone();
            //Account acc = this;
            Account acc = (Account) this.clone();

           // acc.historyAcc = getCountCurrancy();
            /*System.out.println("h1_________________________________V");
            for (Account acc1: this.historyAcc
            ) {
                System.out.println("this historyAcc" + acc1);
            }
            System.out.println("h1_________________________________^");
            System.out.println("h1acc_________________________________V");
            for (Account acc1: acc.historyAcc
            ) {
                System.out.println("acc historyAcc" + acc1);
            }
            System.out.println("h1acc_________________________________^");*/

            historyAcc.add(acc);

           /* System.out.println("clone = " + historyAcc.size() + " " + acc +" h =" +historyAcc.get(historyAcc.size()-1));
            System.out.println("h1_________________________________V");
            for (Account acc1: this.historyAcc
            ) {
                System.out.println("this historyAcc" + acc1);
            }
            System.out.println("h1_________________________________^");
            System.out.println("h1acc_________________________________V");
            for (Account acc1: acc.historyAcc
            ) {
                System.out.println("acc historyAcc" + acc1);
            }
            System.out.println("h1acc_________________________________^");*/
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}

package ru.inno.edu;

import ru.inno.edu.enumCur.Currancy;
import ru.inno.edu.interfaceAcc.RuleCountCur;
import ru.inno.edu.interfaceAcc.RuleNameAcc;

import java.util.HashMap;

public class Account {

    private String name;
    private HashMap<Currancy, Integer> countCurrancy;

    private RuleCountCur ruleCountCur;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account(String name, RuleNameAcc ruleNameAcc, RuleCountCur ruleCountCur) {
        if (ruleNameAcc.checkName(name)) throw new IllegalArgumentException("name is null. Put name");
        this.name = name;
        this.ruleCountCur = ruleCountCur;

        countCurrancy = new HashMap<>();
    }

    public HashMap<Currancy, Integer> getCountCurrancy() {
        return new HashMap<>( countCurrancy);
    }

    public void addCurrancy(Currancy currancy, int count){
        System.out.println(currancy +" "+ count);
        if (this.ruleCountCur.check(count)) throw  new IllegalArgumentException("count acc must be >0");
        countCurrancy.put(currancy, count);
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", countCurrancy=" + countCurrancy +
                '}';
    }
}

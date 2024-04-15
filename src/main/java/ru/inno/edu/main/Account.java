package ru.inno.edu.main;

import ru.inno.edu.enumCur.Currancy;
import ru.inno.edu.interfaceAcc.UndoState;
import ru.inno.edu.interfaceAcc.RuleCountCur;
import ru.inno.edu.interfaceAcc.RuleNameAcc;

import java.util.*;

public class Account implements Cloneable {

    private String name;
    private HashMap<Currancy, Integer> countCurrancy;

    private RuleCountCur ruleCountCur;

    private ArrayDeque<UndoState> historyState = new ArrayDeque();

    public String getName() {
        return name;
    }

    public HashMap<Currancy, Integer> getCountCurrancy() {
        return new HashMap<>(countCurrancy);
    }

    public void setName(String name) {
        String prevName = this.name;
        this.historyState.add((acc)->acc.name = prevName); // не понял почему не срабатывает, если подставить вместо prevName - this.name

        this.name = name;
    }

    public Account(String name, RuleNameAcc ruleNameAcc, RuleCountCur ruleCountCur) {
        if (ruleNameAcc.checkName(name)) throw new IllegalArgumentException("name is null. Put name");
        this.name = name;
        this.ruleCountCur = ruleCountCur;

        countCurrancy = new HashMap<>();
    }

    public void addCurrancy(Currancy currancy, int count){
        if (this.ruleCountCur.check(count)) throw  new IllegalArgumentException("count acc must be >0");

        Integer counCur = this.countCurrancy.get(currancy);
        if (counCur != null)
            this.historyState.add((acc)-> acc.countCurrancy.put(currancy, counCur));
        else
            this.historyState.add((acc)-> acc.countCurrancy.remove(currancy));

        this.countCurrancy.put(currancy, count);
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

        accTemp.countCurrancy = new HashMap<>();
        accTemp.countCurrancy = (HashMap<Currancy, Integer>) countCurrancy.clone();
        return accTemp;
    }

    public void undo(){
        UndoState able = this.historyState.pollLast();

        if (able == null) throw new NoSuchElementException("state histary is empty");
        able.undo(this);

        System.out.println("undo = " + this);
    }

    public AccSave getSave (){
        AccSave accsave = new AccSave(this.getName(), this.getCountCurrancy());

        return accsave;
    }
}

package ru.inno.edu.main;

import ru.inno.edu.enumCur.Currancy;

import java.util.HashMap;


// класс для сохранения состояния Account
public class AccSave {
    private String name;
    private HashMap<Currancy, Integer> countCurrancy;

    @Override
    public String toString() {
        return "AccSave{" +
                "name='" + name + '\'' +
                ", countCurrancy=" + countCurrancy +
                '}';
    }

    public AccSave(String name, HashMap<Currancy, Integer> countCurrancy) {
        this.name = name;
        this.countCurrancy = countCurrancy;
    }

    public String getName() {
        return name;
    }

    public HashMap<Currancy, Integer> getCountCurrancy() {
        return new HashMap<>(countCurrancy);
    }
}

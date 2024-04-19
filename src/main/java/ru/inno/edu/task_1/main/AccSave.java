package ru.inno.edu.task_1.main;

import ru.inno.edu.task_1.enumCur.Currancy;

import java.util.HashMap;
import java.util.Map;


// класс для сохранения состояния Account
public class AccSave {
    private String name;
    private Map<Currancy, Integer> countCurrancy;

    @Override
    public String toString() {
        return "AccSave{" +
                "name='" + name + '\'' +
                ", countCurrancy=" + countCurrancy +
                '}';
    }

    public AccSave(String name, Map<Currancy, Integer> countCurrancy) {
        this.name = name;
        this.countCurrancy = countCurrancy;
    }

    public String getName() {
        return name;
    }

    public Map<Currancy, Integer> getCountCurrancy() {
        return new HashMap<>(countCurrancy);
    }
}

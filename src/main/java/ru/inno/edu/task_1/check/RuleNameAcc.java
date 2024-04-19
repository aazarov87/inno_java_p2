package ru.inno.edu.task_1.check;

public class RuleNameAcc implements ru.inno.edu.task_1.interfaceAcc.RuleNameAcc {
    @Override
    public boolean checkName(String name) {
        return (name == null || name.isEmpty());
    }
}

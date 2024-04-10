package ru.inno.edu.check;

public class RuleNameAcc implements ru.inno.edu.interfaceAcc.RuleNameAcc {
    @Override
    public boolean checkName(String name) {
        return (name == null || name.isEmpty());
    }
}

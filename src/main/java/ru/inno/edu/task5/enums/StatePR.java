package ru.inno.edu.task5.enums;

public enum StatePR {

    WORK("Работает"),
    OPEN("Открыт"),
    CLOSE("Закрыт");

    private String name;

    StatePR(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}

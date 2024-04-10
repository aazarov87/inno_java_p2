package ru.inno.edu.enumCur;

public enum Currancy {
    USD("Доллар США"),
    RUB("Российский рубль"),
    EUR("Евро");

    private String name;

    Currancy(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Currancy{" +
                "name='" + name + '\'' +
                '}';
    }
}

package ru.inno.edu.exampleJpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String fio;

    @Override
    public String toString() {
        return "\nUsers{" +
                "id=" + id +
                ", text='" + fio + '\'' +
                '}';
    }

    public String getText() {
        return fio;
    }

    public void setText(String text) {
        this.fio = text;
    }

    public Users( String text) {
        this.fio = text;
    }

    public Users() {
    }

}

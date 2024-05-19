package ru.inno.edu.exampleJpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    int id;

    String text;

    public Users() {
    }
}

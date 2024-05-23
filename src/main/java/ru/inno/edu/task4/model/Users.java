package ru.inno.edu.task4.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(nullable = false, unique = true)
    String username;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(username, users.username) && Objects.equals(fio, users.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, fio);
    }

    @Column(nullable = false)
    String fio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users(String username, String fio) {
        this.username = username;
        this.fio = fio;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fio='" + fio + '\'' +
                '}';
    }
}

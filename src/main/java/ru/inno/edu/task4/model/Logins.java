package ru.inno.edu.task4.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Logins {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(nullable = false)
    LocalDateTime access_date;
    @Column(nullable = false)
    Integer userId;

    @Column(nullable = false)
    String application;
    @Override
    public String toString() {
        return "Logins{" +
                "id=" + id +
                ", access_date=" + access_date +
                ", user_id=" + userId +
                ", application='" + application + '\'' +
                '}';
    }

    public Logins() {
    }

    public Logins(LocalDateTime access_date, Integer user_id, String application) {
        this.access_date = access_date;
        this.userId = user_id;
        this.application = application;
    }
}

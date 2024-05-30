package ru.inno.edu.task5.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "account_pool_id")
    Integer accountPoolId;

    @Column(name = "account_number")
    String accountNumber;

    @Column(name = "bussy")
    boolean bussy;

    public AccountModel() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountPoolId=" + accountPoolId +
                ", accountNumber='" + accountNumber + '\'' +
                ", bussy=" + bussy +
                '}';
    }
}

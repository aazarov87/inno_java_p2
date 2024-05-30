package ru.inno.edu.task5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tpp_product_register")
@Getter
@Setter
public class TppProductRegisterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer productId;

    @Column(nullable = false)
    String  type;

    Integer account;

    @Column(name = "currency_code")
    String currencyCode;
    String state;
    @Column(name = "account_number")
    String accountNumber;

    @Override
    public String toString() {
        return "TppProductRegister{" +
                "id=" + id +
                ", product_id=" + productId +
                ", type='" + type + '\'' +
                ", account=" + account +
                ", currency_code='" + currencyCode + '\'' +
                ", state='" + state + '\'' +
                ", account_number='" + accountNumber + '\'' +
                '}';
    }

    public TppProductRegisterModel(Integer product_id, String type, Integer account, String currency_code, String state, String account_number) {
        this.productId = product_id;
        this.type = type;
        this.account = account;
        this.currencyCode = currency_code;
        this.state = state;
        this.accountNumber = account_number;
    }

    public TppProductRegisterModel() {
    }
}

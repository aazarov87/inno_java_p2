package ru.inno.edu.task5.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Table(name = "account_pool")
@AllArgsConstructor
@Getter
public class AccountPoolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "branch_code")
    String branchCode;
    @Column(name = "currency_code")
    String currencyCode;
    @Column(name = "mdm_code")
    String mdmCode;
    @Column(name = "priority_code")
    String priorityCode;
    @Column(name = "registry_type_code")
    String registryTypeCode;

    public AccountPoolModel() {
    }

    @Override
    public String toString() {
        return "AccountPool{" +
                "id=" + id +
                ", branchCode='" + branchCode + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", mdmCode='" + mdmCode + '\'' +
                ", priorityCode='" + priorityCode + '\'' +
                ", registryTypeCode='" + registryTypeCode + '\'' +
                '}';
    }
}

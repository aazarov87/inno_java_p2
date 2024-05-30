package ru.inno.edu.task5.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tpp_ref_product_register_type")
public class TppProductRegisterTypeModel {

    public TppProductRegisterTypeModel(Integer internalId, String value, String registerTypeName, String productClassCode, LocalDateTime registerTypeStartDate, LocalDateTime registerTypeEndDate, String accountType) {
        this.internalId = internalId;
        this.value = value;
        this.registerTypeName = registerTypeName;
        this.productClassCode = productClassCode;
        this.registerTypeStartDate = registerTypeStartDate;
        this.registerTypeEndDate = registerTypeEndDate;
        this.accountType = accountType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer internalId;
    @Column(nullable = false)
    String value;

    @Column(nullable = false)
    String registerTypeName;

    @Column(nullable = false)
    String productClassCode;
    LocalDateTime registerTypeStartDate;
    LocalDateTime registerTypeEndDate;
    String accountType;

    public TppProductRegisterTypeModel() {
    }

    @Override
    public String toString() {
        return "TppProductRegisterType{" +
                "internalId=" + internalId +
                ", value='" + value + '\'' +
                ", registerTypeName='" + registerTypeName + '\'' +
                ", productClassCode='" + productClassCode + '\'' +
                ", registerTypeStartDate=" + registerTypeStartDate +
                ", registerTypeEndDate=" + registerTypeEndDate +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}

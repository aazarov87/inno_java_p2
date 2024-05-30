package ru.inno.edu.task5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tpp_product")
@Getter
@Setter
public class TppProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "product_code_id") Integer productCodeId;
    @Column(name = "client_id") Integer clientId;
    @Column(name = "type") String type;
    @Column(name = "number") String number;
    @Column(name = "priority") Integer priority;
    @Column(name = "date_of_conclusion") LocalDateTime dateOfConclusion;
    @Column(name = "start_date_time") LocalDateTime startDateTime;
    @Column(name = "end_date_time") LocalDateTime endDateTime;
    @Column(name = "days") Integer days;
    @Column(name = "penalty_rate") double penaltyRate;
    @Column(name = "nso") double nso;
    @Column(name = "threshold_amount") double thresholdAmount;
    @Column(name = "requisite_type") String requisiteType;
    @Column(name = "interest_rate_type") String interestRateType;
    @Column(name = "tax_rate") double taxRate;
    @Column(name = "reasone_close") String reasoneClose;
    @Column(name = "state")  String state;


    public TppProductModel() {
    }
}

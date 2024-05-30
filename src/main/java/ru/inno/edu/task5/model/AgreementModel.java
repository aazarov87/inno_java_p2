package ru.inno.edu.task5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "agreement")
@Setter
@Getter
public class AgreementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "product_id") Integer productId;
    @Column(name = "general_agreement_id") String generalAgreementId;
    @Column(name = "supplementary_agreement_id") String supplementaryAgreementId;
    @Column(name = "arrangement_type") String arrangementType;
    @Column(name = "sheduler_job_id") Integer shedulerJobId;
    @Column(name = "number") String  number;
    @Column(name = "opening_date") LocalDateTime openingDate;
    @Column(name = "closing_date") LocalDateTime closingDate;
    @Column(name = "cancel_date") LocalDateTime cancelDate;
    @Column(name = "validity_duration") Integer validityDuration;
    @Column(name = "cancellation_reason") String cancellationReason;
    @Column(name = "status") String status;
    @Column(name = "interest_calculation_date") LocalDateTime interestCalculationDate;
    @Column(name = "interest_rate") double interestRate;
    @Column(name = "coefficient") double coefficient;
    @Column(name = "coefficient_action") String coefficientAction;
    @Column(name = "minimum_interest_rate") double minimumInterestRate;
    @Column(name = "minimum_interest_rate_coefficient") double minimumInterestRateCoefficient;
    @Column(name = "minimum_interest_rate_coefficient_action") String minimumInterestRateCoefficientAction;
    @Column(name = "maximal_interest_rate") double maximalInterestRate;
    @Column(name = "maximal_interest_rate_coefficient") double maximalInterestRateCoefficient;
    @Column(name = "maximal_interest_rate_coefficient_action") String maximalInterestRateCoefficientAction;
}

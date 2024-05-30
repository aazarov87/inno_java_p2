package ru.inno.edu.task5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AgreementInput {

    @Setter
    String generalAgreementId, supplementaryAgreementId,arrangementType, cancellationReason, status, coefficientAction, minimumInterestRateCoefficient, minimumInterestRateCoefficientAction, maximalnterestRateCoefficientAction;

    Integer shedulerJobId, validityDuration, maximalnterestRate,maximalnterestRateCoefficient;

    @NotNull
    String number;

    @NotNull
    LocalDateTime openingDate;

    LocalDateTime closingDate, CancelDate, interestCalculationDate;

    double interestRate, coefficient, minimumInterestRate;
    public AgreementInput() {
    }

    @Override
    public String toString() {
        return "AgreementInput{" +
                "generalAgreementId='" + generalAgreementId + '\'' +
                ", supplementaryAgreementId='" + supplementaryAgreementId + '\'' +
                '}';
    }
}

package ru.inno.edu.task5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ProductInput {

    Integer instanceId;

    @NotNull
    String productType;

    @NotNull
    String productCode;

    @NotNull
    String registerType;

    @NotNull
    String mdmCode;

    @NotNull
    String contractNumber;

    @NotNull
    LocalDateTime contractDate;

    @NotNull
    Integer priority;

    double interestRatePenalty, minimalBalance,thresholdAmount, taxPercentageRate, technicalOverdraftLimitAmount;

    String accountingDetails, rateType;

    @NotNull
    Integer contractId;

    @NotNull
    String branchCode;
    @NotNull
    String isoCurrencyCode;

    @NotNull
    String urgencyCode;

    Integer referenceCode;

    AgreementInput[] instanceArrangement;

    public ProductInput() {
    }

    @Override
    public String toString() {
        return "ProductInput{" +
                "instanceId=" + instanceId +
                ", productType='" + productType + '\'' +
                ", productCode='" + productCode + '\'' +
                ", registerType='" + registerType + '\'' +
                ", mdmCode='" + mdmCode + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                ", contractDate=" + contractDate +
                ", priority=" + priority +
                ", interestRatePenalty=" + interestRatePenalty +
                ", minimalBalance=" + minimalBalance +
                ", thresholdAmount=" + thresholdAmount +
                ", taxPercentageRate=" + taxPercentageRate +
                ", technicalOverdraftLimitAmount=" + technicalOverdraftLimitAmount +
                ", accountingDetails='" + accountingDetails + '\'' +
                ", rateType='" + rateType + '\'' +
                ", contractId=" + contractId +
                ", branchCode='" + branchCode + '\'' +
                ", isoCurrencyCode='" + isoCurrencyCode + '\'' +
                ", urgencyCode='" + urgencyCode + '\'' +
                ", referenceCode=" + referenceCode +
                ", instanceArrangement=" + Arrays.toString(instanceArrangement) +
                '}';
    }
}

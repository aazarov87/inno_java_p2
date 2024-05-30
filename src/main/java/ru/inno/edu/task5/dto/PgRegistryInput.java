package ru.inno.edu.task5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PgRegistryInput {

    @NotNull
    Integer instanceId;
    String registryTypeCode, accountType, currencyCode, branchCode,priorityCode, mdmCode, clientCode, trainRegion, counter, salesCode;

    @Override
    public String toString() {
        return "PgRegistryInput{" +
                "instanceId=" + instanceId +
                ", registryTypeCode='" + registryTypeCode + '\'' +
                ", accountType='" + accountType + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", priorityCode='" + priorityCode + '\'' +
                ", mdmCode='" + mdmCode + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", trainRegion='" + trainRegion + '\'' +
                ", counter='" + counter + '\'' +
                ", salesCode='" + salesCode + '\'' +
                '}';
    }

    public PgRegistryInput(Integer instanceId, String registryTypeCode, String accountType, String currencyCode, String branchCode, String priorityCode, String mdmCode, String clientCode, String trainRegion, String counter, String salesCode) {
        this.instanceId = instanceId;
        this.registryTypeCode = registryTypeCode;
        this.accountType = accountType;
        this.currencyCode = currencyCode;
        this.branchCode = branchCode;
        this.priorityCode = priorityCode;
        this.mdmCode = mdmCode;
        this.clientCode = clientCode;
        this.trainRegion = trainRegion;
        this.counter = counter;
        this.salesCode = salesCode;
    }

    public PgRegistryInput() {
    }
}

package ru.inno.edu.task5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inno.edu.task5.dto.AgreementInput;
import ru.inno.edu.task5.dto.PgRegistryInput;
import ru.inno.edu.task5.dto.ProductInput;
import ru.inno.edu.task5.enums.StatePR;
import ru.inno.edu.task5.exceptions.NotExistsData;
import ru.inno.edu.task5.model.AgreementModel;
import ru.inno.edu.task5.model.TppProductModel;
import ru.inno.edu.task5.model.TppProductRegisterModel;
import ru.inno.edu.task5.model.TppProductRegisterTypeModel;
import ru.inno.edu.task5.repo.AgreementRepo;
import ru.inno.edu.task5.repo.TppProductRegisterTypeRepo;
import ru.inno.edu.task5.repo.TppProductRepo;

import java.util.*;

@Service
public class TppProductService {

    @Autowired
    TppProductRepo tppProductRepo;

    @Autowired
    TppProductRegisterTypeRepo tppProductRegisterTypeRepo;

    @Autowired
    AgreementRepo agreementRepo;

    @Autowired
    TppProductRegisterService tppProductRegisterService;

    private final String accType = "Клиентский";

    public Map<String, Object> exec(ProductInput productInput) throws Exception {

        if (productInput.getInstanceId() == null)
            return create(productInput);
        else
            return update(productInput);
    }

    private void checkExistsAgreement(ProductInput productInput) throws NotExistsData {
        for (AgreementInput agreementInput : productInput.getInstanceArrangement()) {
            if (!agreementRepo.findByNumber(agreementInput.getNumber()).isEmpty())
                throw new NotExistsData("Параметр № Дополнительного соглашения(сделки) Number "+agreementInput.getNumber()+" уже существует для ЭП с ИД " + productInput.getContractNumber());
        }
    }

    private Map<String, Object> create(ProductInput productInput) throws Exception {

        TppProductModel tppProductModel = tppProductRepo.findByNumber(productInput.getContractNumber());
        if (tppProductModel != null)
            throw new NotExistsData("№ договора "+productInput.getContractNumber()+" уже существует для ЭП с ИД " + tppProductModel.getId());

        checkExistsAgreement(productInput);

        List<TppProductRegisterTypeModel> tppProductRegisterTypeModelList = tppProductRegisterTypeRepo.findByProductClassCodeAndAccountType(productInput.getProductCode(), accType);
        if (tppProductRegisterTypeModelList.isEmpty())
            throw new NotExistsData("Код продукта "+productInput.getProductCode()+" не найден в каталоге продуктов tpp_ref_product_class");

        tppProductModel = new TppProductModel();
        tppProductModel.setNumber(productInput.getContractNumber());
        tppProductModel.setStartDateTime(productInput.getContractDate());
        tppProductModel.setClientId(Integer.valueOf(productInput.getMdmCode()));
        tppProductModel.setPriority(productInput.getPriority());
        tppProductModel.setPenaltyRate(productInput.getInterestRatePenalty());
        tppProductModel.setInterestRateType(productInput.getRateType());
        tppProductModel.setState(StatePR.OPEN.getName());

        tppProductRepo.save(tppProductModel);

        List<TppProductRegisterModel> tppProductRegisterModels = new ArrayList<>();
        for (TppProductRegisterTypeModel tppProductRegisterTypeModel : tppProductRegisterTypeModelList) {
            PgRegistryInput pgRegistryInput = new PgRegistryInput();

            pgRegistryInput.setRegistryTypeCode(tppProductRegisterTypeModel.getValue());
            pgRegistryInput.setInstanceId(tppProductModel.getId());
            pgRegistryInput.setBranchCode(productInput.getBranchCode());
            pgRegistryInput.setCurrencyCode(productInput.getIsoCurrencyCode());
            pgRegistryInput.setMdmCode(productInput.getMdmCode());
            pgRegistryInput.setPriorityCode(productInput.getAccountingDetails());

            tppProductRegisterModels.add(tppProductRegisterService.add(pgRegistryInput));
        }

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("instanceId:", tppProductModel.getId());
        body.put("listregisterId: ", tppProductRegisterModels);

        return body;
    }

    private Map<String, Object> update(ProductInput productInput) throws Exception {

        TppProductModel tppProductModel =  tppProductRepo.findProduct(productInput.getInstanceId());
        if (tppProductModel == null)
            throw new NotExistsData("Экземпляр продукта с параметром "+ productInput.getInstanceId() +" не найден");

        checkExistsAgreement(productInput);

        List<Integer> agreementModelList = new ArrayList<>();
        for (AgreementInput agreementInput : productInput.getInstanceArrangement()) {
            AgreementModel agreementModel = new AgreementModel();

            agreementModel.setProductId(tppProductModel.getId());
            agreementModel.setGeneralAgreementId(agreementInput.getGeneralAgreementId());
            agreementModel.setSupplementaryAgreementId(agreementInput.getSupplementaryAgreementId());
            agreementModel.setShedulerJobId(agreementInput.getShedulerJobId());
            agreementModel.setNumber(agreementInput.getNumber());
            agreementModel.setOpeningDate(agreementInput.getOpeningDate());
            agreementModel.setClosingDate(agreementInput.getClosingDate());
            agreementModel.setCancelDate(agreementInput.getCancelDate());
            agreementModel.setValidityDuration(agreementInput.getValidityDuration());
            agreementModel.setCancellationReason(agreementInput.getCancellationReason());
            agreementModel.setStatus(agreementInput.getStatus());
            agreementModel.setInterestCalculationDate(agreementInput.getInterestCalculationDate());
            agreementModel.setInterestRate(agreementInput.getInterestRate());
            agreementModel.setCoefficient(agreementInput.getCoefficient());
            agreementModel.setMaximalInterestRate(agreementInput.getMaximalnterestRate());
            agreementModel.setMaximalInterestRateCoefficient(agreementInput.getMaximalnterestRateCoefficient());
            agreementModel.setMaximalInterestRateCoefficientAction(agreementInput.getMaximalnterestRateCoefficientAction());

            agreementModelList.add(agreementRepo.save(agreementModel).getId());
        }

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("instanceId:", "");
        body.put("listregisterId: ", "");
        body.put("supplementaryAgreementId: ", agreementModelList);

        return body;

    }
}

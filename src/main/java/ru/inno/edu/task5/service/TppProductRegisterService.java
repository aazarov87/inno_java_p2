package ru.inno.edu.task5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inno.edu.task5.dto.PgRegistryInput;
import ru.inno.edu.task5.enums.StatePR;
import ru.inno.edu.task5.exceptions.NotExistsData;
import ru.inno.edu.task5.model.AccountModel;
import ru.inno.edu.task5.model.TppProductRegisterModel;
import ru.inno.edu.task5.repo.AccountRepo;
import ru.inno.edu.task5.repo.TppProductRegisterRepo;

@Service
public class TppProductRegisterService {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    TppProductRegisterRepo tppProductRegisterRepo;

    @Autowired
    CheckRecordFromDB checkRecordFromDB;

    public TppProductRegisterModel add(PgRegistryInput pgRegistryInput) throws Exception {

        checkRecordFromDB.checkTppProductRegister(pgRegistryInput);
        checkRecordFromDB.checkTppProductRegisterType(pgRegistryInput);

        AccountModel accountModel = accountRepo.findFirstAccount(pgRegistryInput.getBranchCode()
                                            , pgRegistryInput.getCurrencyCode()
                                            , pgRegistryInput.getMdmCode()
                                            , pgRegistryInput.getPriorityCode()
                                            , pgRegistryInput.getRegistryTypeCode());

        if(accountModel ==null)
            throw new NotExistsData("Не найден счет");

        TppProductRegisterModel tppProductRegisterModel = new TppProductRegisterModel(pgRegistryInput.getInstanceId(), pgRegistryInput.getRegistryTypeCode(), accountModel.getId(), pgRegistryInput.getCurrencyCode(), StatePR.OPEN.getName(), accountModel.getAccountNumber());

        tppProductRegisterRepo.save(tppProductRegisterModel);

        return tppProductRegisterModel;
    }
}

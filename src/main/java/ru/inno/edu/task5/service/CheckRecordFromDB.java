package ru.inno.edu.task5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inno.edu.task5.dto.PgRegistryInput;
import ru.inno.edu.task5.exceptions.EmptyFieldInputData;
import ru.inno.edu.task5.exceptions.NotExistsData;
import ru.inno.edu.task5.model.TppProductRegisterModel;
import ru.inno.edu.task5.model.TppProductRegisterTypeModel;
import ru.inno.edu.task5.repo.TppProductRegisterRepo;
import ru.inno.edu.task5.repo.TppProductRegisterTypeRepo;

@Service
public class CheckRecordFromDB {

    @Autowired
    TppProductRegisterRepo tppProductRegisterRepo;

    @Autowired
    TppProductRegisterTypeRepo tppProductRegisterTypeRepo;

    public void checkTppProductRegister(PgRegistryInput pgRegistryInput) throws EmptyFieldInputData {
        TppProductRegisterModel tppProductRegisterModel = tppProductRegisterRepo.findByProductIdAndType(pgRegistryInput.getInstanceId(), pgRegistryInput.getRegistryTypeCode());
        if (tppProductRegisterModel != null)
            throw new EmptyFieldInputData("Параметр registryTypeCode тип регистра "+pgRegistryInput.getRegistryTypeCode()+" уже существует для ЭП с ИД  "+ pgRegistryInput.getInstanceId());
    }


    public void checkTppProductRegisterType (PgRegistryInput pgRegistryInput) throws NotExistsData {
        TppProductRegisterTypeModel tppProductRegisterTypeModel = tppProductRegisterTypeRepo.findByValue(pgRegistryInput.getRegistryTypeCode());

        if (tppProductRegisterTypeModel == null)
            throw new NotExistsData("Код Продукта "+pgRegistryInput.getRegistryTypeCode()+" не найдено в Каталоге продуктов TppProductRegisterType для данного типа Регистра");
    }
}

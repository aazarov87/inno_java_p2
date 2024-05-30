package ru.inno.edu.task5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.edu.task5.model.TppProductRegisterTypeModel;

import java.util.List;

public interface TppProductRegisterTypeRepo extends JpaRepository<TppProductRegisterTypeModel, Integer> {

    TppProductRegisterTypeModel findByValue(String value);

    TppProductRegisterTypeModel findByInternalId(Integer Id);

    List<TppProductRegisterTypeModel> findAll();


    List<TppProductRegisterTypeModel> findByProductClassCodeAndAccountType(String productClassCode, String accountType);
}

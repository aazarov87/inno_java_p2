package ru.inno.edu.task5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.edu.task5.model.AgreementModel;

import java.util.List;

public interface AgreementRepo extends JpaRepository<AgreementModel, Integer> {

    List<AgreementModel> findByNumber (String number);
}

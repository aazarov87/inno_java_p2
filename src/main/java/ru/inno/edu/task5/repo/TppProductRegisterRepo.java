package ru.inno.edu.task5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.edu.task5.model.TppProductRegisterModel;

public interface TppProductRegisterRepo extends JpaRepository<TppProductRegisterModel, Integer> {

    TppProductRegisterModel findByProductIdAndType(Integer ProductId, String Type);
}

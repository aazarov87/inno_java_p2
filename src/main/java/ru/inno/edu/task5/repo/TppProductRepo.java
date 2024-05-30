package ru.inno.edu.task5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inno.edu.task5.model.TppProductModel;

public interface TppProductRepo extends JpaRepository<TppProductModel, Integer> {

    TppProductModel findByNumber(String number);

    @Query(value = """
       SELECT prod.* FROM tpp_product prod
       WHERE prod.id = ?1 
  """, nativeQuery = true)
    TppProductModel findProduct(Integer id);
}

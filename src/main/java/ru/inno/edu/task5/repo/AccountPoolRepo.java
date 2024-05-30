package ru.inno.edu.task5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inno.edu.task5.model.AccountPoolModel;

import java.util.List;

public interface AccountPoolRepo extends JpaRepository<AccountPoolModel, Integer> {

    List<AccountPoolModel> findAll();

    @Query(value = """
       SELECT acc.* FROM account_pool acc
       WHERE acc.branch_code = ?1 
       and acc.currency_code = ?2
       and acc.mdm_code = ?3
       and acc.priority_code = ?4
       and acc.registry_type_code = ?5
  """, nativeQuery = true)
    List<AccountPoolModel> findFirstAccountPool(String branchCode, String currencyCode, String mdmCode, String priorityCode, String registryTypeCode);
}

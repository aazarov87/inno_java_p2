package ru.inno.edu.task5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inno.edu.task5.model.AccountModel;

public interface AccountRepo extends JpaRepository<AccountModel, Integer> {

    @Query(value = """
       SELECT acc.* FROM account_pool acc_pool, account acc
       WHERE acc_pool.branch_code = ?1 
       and acc_pool.currency_code = ?2
       and acc_pool.mdm_code = ?3
       and acc_pool.priority_code = ?4
       and acc_pool.registry_type_code = ?5
       and acc.account_pool_id = acc_pool.id
       LIMIT 1
  """, nativeQuery = true)
    AccountModel findFirstAccount(String branchCode, String currencyCode, String mdmCode, String priorityCode, String registryTypeCode);
}

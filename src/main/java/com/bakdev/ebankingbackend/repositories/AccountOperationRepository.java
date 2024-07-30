package com.bakdev.ebankingbackend.repositories;

import com.bakdev.ebankingbackend.entities.AccountOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {

    // La liste des opérations d'un compte
     List<AccountOperation> findByBankAccountId(String accountId);
    Page<AccountOperation> findByBankAccountId(String accountId , Pageable pageable);


}

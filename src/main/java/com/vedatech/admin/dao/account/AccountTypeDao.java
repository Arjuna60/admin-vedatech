package com.vedatech.admin.dao.account;

import com.vedatech.admin.model.bank.AccountingType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountTypeDao extends CrudRepository<AccountingType, Long> {

    @Query("select p from AccountingType p where p.nameAccount like %?1%")
    public List<AccountingType> findByNombre(String term);

}

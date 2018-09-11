package com.vedatech.admin.service.account;

import com.vedatech.admin.dao.account.AccountTypeDao;
import com.vedatech.admin.model.bank.AccountingType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface AccountingTypeServcie  {

    public List<AccountingType> findAllAccountName();

    List<AccountingType> findByNombre(String term);



}

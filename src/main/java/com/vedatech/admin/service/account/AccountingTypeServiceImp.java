package com.vedatech.admin.service.account;

import com.vedatech.admin.dao.account.AccountTypeDao;
import com.vedatech.admin.model.bank.AccountingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountingTypeServiceImp implements AccountingTypeServcie {

    @Autowired
    AccountTypeDao accountTypeDao;

    @Override
    public List<AccountingType> findAllAccountName() {
        return (List<AccountingType>) accountTypeDao.findAll();
    }

    @Override
    public List<AccountingType> findByNombre(String term) {
        return accountTypeDao.findByNombre(term);
    }
}

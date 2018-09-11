package com.vedatech.admin.service.bank;


import com.vedatech.admin.model.bank.Bank;

import java.util.List;
import java.util.Optional;

public interface BankService {

    public List<Bank> findAll();
    void save(Bank bank);
    Bank findByAccount(long accountNumber);
    Bank findBankById(Long id);
}

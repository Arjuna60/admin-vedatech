package com.vedatech.admin.service.bank;

import com.vedatech.admin.dao.bankDao.BankDao;
import com.vedatech.admin.model.bank.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BankServiceImp implements BankService {

    @Autowired
    BankDao bankDao;

    @Override
    public List<Bank> findAll() {
        return (List<Bank>) bankDao.findAll();
    }

    @Override
    public void save(Bank bank) {
        bankDao.save(bank);
    }

    @Override
    public Bank findByAccount(long accountNumber) {
        return bankDao.findBankByAccountNumber(accountNumber);
    }

    @Override
    public Bank findBankById(Long id) {
        return bankDao.findBankById(id);
    }

}

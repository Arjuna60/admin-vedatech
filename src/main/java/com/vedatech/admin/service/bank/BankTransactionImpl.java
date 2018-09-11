package com.vedatech.admin.service.bank;

import com.vedatech.admin.dao.bankDao.BankTransactionDao;
import com.vedatech.admin.model.bank.BankTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BankTransactionImpl implements BankTransactionService {

    @Autowired
    BankTransactionDao bankTransactionDao;

    @Override
    public BankTransaction save(BankTransaction bankTransaction) {
         return bankTransactionDao.save(bankTransaction);
    }

    @Override
    public BankTransaction findByReferenceAndByBankId(Long reference, Long id) {
        return bankTransactionDao.findBankTransactionByReferenceAndBank_Id(reference, id);
    }

    @Override
    public List<BankTransaction> findBankTransactionByDateGreaterThanEqualAndDateLessThanEqualAndBank_Id(Date date1, Date date2, Long id) {
        return bankTransactionDao.findBankTransactionByDateGreaterThanEqualAndDateIsLessThanEqualAndBank_Id(date1, date2, id);
    }

    @Override
    public void deleteBankTransaction(BankTransaction bankTransaction) {
        bankTransactionDao.delete(bankTransaction);
    }

    @Override
    public BankTransaction findBankTransactionByIdAndBank_Id(Long idTrans, Long idBank) {
        return bankTransactionDao.findBankTransactionByIdAndBank_Id(idTrans, idBank);
    }


}

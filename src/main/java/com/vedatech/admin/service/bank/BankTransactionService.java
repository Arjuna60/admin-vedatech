package com.vedatech.admin.service.bank;


import com.vedatech.admin.model.bank.Bank;
import com.vedatech.admin.model.bank.BankTransaction;

import java.util.Date;
import java.util.List;

public interface BankTransactionService {

    BankTransaction save(BankTransaction bankTransaction);

    BankTransaction findByReferenceAndByBankId(Long reference, Long id);

    List<BankTransaction> findBankTransactionByDateGreaterThanEqualAndDateLessThanEqualAndBank_Id(Date date1, Date date2, Long id);

    void deleteBankTransaction(BankTransaction bankTransaction);

    BankTransaction findBankTransactionByIdAndBank_Id(Long idTrans, Long idBank);

}

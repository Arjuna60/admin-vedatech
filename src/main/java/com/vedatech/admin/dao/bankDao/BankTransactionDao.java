package com.vedatech.admin.dao.bankDao;

import com.vedatech.admin.model.bank.BankTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BankTransactionDao extends CrudRepository<BankTransaction, Long> {

    @Query("select p from BankTransaction p where p.reference like %?1%")
    public List<BankTransaction> findByReference(Long term);

    BankTransaction findBankTransactionByReferenceAndBank_Id(Long reference, Long id);

    List<BankTransaction> findBankTransactionByDateGreaterThanEqualAndDateIsLessThanEqualAndBank_Id(Date date1, Date date2, Long id);

    BankTransaction findBankTransactionByIdAndBank_Id(Long idTrans, Long idBank);

}
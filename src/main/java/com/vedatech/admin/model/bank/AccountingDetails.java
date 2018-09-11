package com.vedatech.admin.model.bank;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accounting_details")
public class AccountingDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String concept;

    @Column
    private Double credit;

    @Column
    private Double debit;

    @Column
    private Double balance;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="account_name_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AccountingType accountingType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountingType getAccountingType() {
        return accountingType;
    }

    public void setAccountingType(AccountingType accountingType) {
        this.accountingType = accountingType;
    }
}

package com.vedatech.admin.model.supplier;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.admin.model.bank.AccountingType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "suppliers")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // @NotEmpty
    @Column(name = "name_supplier")
    private String nameSupplier;

    @Column(name = "taxes")
    private boolean taxes;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="accounting_type_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    AccountingType accountingType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public boolean isTaxes() {
        return taxes;
    }

    public void setTaxes(boolean taxes) {
        this.taxes = taxes;
    }

    public AccountingType getAccountingType() {
        return accountingType;
    }

    public void setAccountingType(AccountingType accountingType) {
        this.accountingType = accountingType;
    }
}

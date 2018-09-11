package com.vedatech.admin.model.bank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "banks")
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // @NotEmpty
    @Column(name = "name_bank")
    private String nameBank;

    // @NotBlank
    @Column(name = "account_number")
    private Long accountNumber;

    //@NotBlank
    //@Email
    @Column(name = "email")
    private String email;

    //@NotBlank
    @Column(name = "phone")
    private String phone;

    @Column(name="address")
    private String address;

    // @NotNull
    @Column(name = "observation")
    private String observation;

    private double balance;

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

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountingType getAccountingType() {
        return accountingType;
    }

    public void setAccountingType(AccountingType accountingType) {
        this.accountingType = accountingType;
    }
}

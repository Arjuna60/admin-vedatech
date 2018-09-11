package com.vedatech.admin.model.bank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vedatech.admin.model.customer.Customer;
import com.vedatech.admin.model.supplier.Supplier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bank_transaction")
public class BankTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    //@Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date date;


    @Column(name = "date_operation")
    //@Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date dateOperation;

   @Column(name = "reference")
    private Long reference;

    @Column(name = "description")
    private String description;

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    @Column(name = "deposit_amount")
    private double depositAmount;

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    @Column(name = "check_amount")
    private double checkAmount;

    private Double balance;

    @ManyToOne
    @JsonBackReference
    private Bank bank;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "accounting_details_id")
    private List<AccountingDetails> accountingDetails;

   // @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  //  @JoinColumn(name = "suppliers_id")
    @ManyToOne
    @JoinColumn(name = "suppliers_id")
    //@JsonBackReference
    private Supplier suppliers;

    @ManyToOne
    @JoinColumn(name = "customers_id")
    //@JsonBackReference
    private Customer customer ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(double checkAmount) {
        this.checkAmount = checkAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<AccountingDetails> getAccountingDetails() {
        return accountingDetails;
    }

    public void setAccountingDetails(List<AccountingDetails> accountingDetails) {
        this.accountingDetails = accountingDetails;
    }

    public Supplier getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Supplier suppliers) {
        this.suppliers = suppliers;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "id=" + id +
                ", date=" + date +
                ", operationDate=" + dateOperation +
                ", reference=" + reference +
                ", description='" + description + '\'' +
                ", depositAmount=" + depositAmount +
                ", checkAmount=" + checkAmount +
                ", Balance=" + balance +
                ", bank=" + bank +
                ", accountingItems=" + accountingDetails +
                '}';
    }
}

package com.vedatech.admin.controller;

import com.vedatech.admin.model.bank.Bank;
import com.vedatech.admin.service.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    BankService bankService;

    //-------------------Create a Bank Account--------------------------------------------------------

    @RequestMapping(value = "/addBankAccount/", method = RequestMethod.POST)
    public ResponseEntity<Bank> createUser(@RequestBody Bank bank, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + bank.getNameBank() );


        if (bankService.findByAccount(bank.getAccountNumber()) != null) {
            System.out.println("A User with name " + bank.getNameBank() + " " + bank.getAccountNumber() + " already exist");
            HttpHeaders headers = new HttpHeaders();
            headers.set("error ", "bank account already exist");
            return new ResponseEntity<Bank>(headers, HttpStatus.CONFLICT);
        }


        bankService.save(bank);
        Bank newBank = bankService.findByAccount(bank.getAccountNumber());

        HttpHeaders headers = new HttpHeaders();
        headers.set("accepted ok","bank account is ok");

        return new ResponseEntity<Bank>(newBank,headers, HttpStatus.CREATED);
    }


    //------------------- Update a Bank Account --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Bank> updateUser(@PathVariable("id") long id, @RequestBody Bank bankAccount) {
        System.out.println("Updating User " + id);

        try {
         //   Bank currentBankAcc = bankService.findBankById(id);
            bankService.save(bankAccount);
            HttpHeaders headers = new HttpHeaders();
            headers.set("success", "the account is update success");
            return new ResponseEntity<Bank>(bankAccount,headers, HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e);
            System.out.println("User with id " + id + " not found");
            HttpHeaders headers = new HttpHeaders();
            headers.set("error", "la cuenta no existe");
            return new ResponseEntity<Bank>(headers, HttpStatus.NOT_FOUND);
        }



    }



    //-------------------Retrieve All Bank Accounts--------------------------------------------------------

    @RequestMapping(value = "/getAllBankAccounts/", method = RequestMethod.GET)
    public ResponseEntity<List<Bank>> listAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        List<Bank> bankAccounts = bankService.findAll();
        List<String> stringList = new ArrayList<>();

        stringList.add("Bank 1");
        stringList.add("Bank 2");

        if (bankAccounts.isEmpty()) {
            headers.set("error", "no existen cuentas bancarias");
            return new ResponseEntity<List<Bank>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }


        return new ResponseEntity<List<Bank>>(bankAccounts, HttpStatus.OK);
    }

}

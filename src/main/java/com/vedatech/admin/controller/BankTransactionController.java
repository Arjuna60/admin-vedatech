package com.vedatech.admin.controller;


import com.vedatech.admin.model.bank.BankTransaction;
import com.vedatech.admin.service.bank.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankTransactionController {

    @Autowired
    BankTransactionService bankTransactionService;

    //-------------------Create a Transaction--------------------------------------------------------

    @PostMapping(value = "/add-bank-transaction")
    public ResponseEntity<String> createBankTransaction(@RequestBody BankTransaction transactions, UriComponentsBuilder ucBuilder) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        HttpHeaders headers = new HttpHeaders();

        if (findBankTransaction(transactions) != null) {
            headers.set("error", "la referencia ya existe");
            return new ResponseEntity<String>(headers, HttpStatus.CONFLICT);
        }
            return saveBankTransaction(transactions);

    }

    //-------------------Get Transactions between Dates and Bank Id--------------------------------------------------------

    @GetMapping(value = "/get-bank-transaction/{after}/{before}/{id}")
    public ResponseEntity<List<BankTransaction>> readBankTransactions(@PathVariable("after") String after, @PathVariable("before") String before, @PathVariable("id") Long id) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        HttpHeaders headers = new HttpHeaders();

        try {

            Date date1 = formatter.parse(after);
            Date date2 = formatter.parse(before);
            List<BankTransaction> bankTransactions = bankTransactionService.findBankTransactionByDateGreaterThanEqualAndDateLessThanEqualAndBank_Id(date1, date2, id);

            return new ResponseEntity<List<BankTransaction>>(bankTransactions, headers, HttpStatus.OK);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<List<BankTransaction>>(headers, HttpStatus.CONFLICT);
    }


    //-------------------update a Bank Transaction--------------------------------------------------------

    @RequestMapping (value = "/update-bank-transaction", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBankTransaction(@RequestBody BankTransaction transactions, UriComponentsBuilder ucBuilder) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        HttpHeaders headers = new HttpHeaders();
    //    BankTransaction updateTransaction = bankTransactionService.findBankTransactionByIdAndBank_Id(transactions.getId(), transactions.getBank().getId());
        System.out.println(transactions.toString());
        return  saveBankTransaction(transactions);
    }



    //-------------------Delete Bank Transaction--------------------------------------------------------

    @DeleteMapping(value = "/delete-bank-transaction")
    public ResponseEntity<String> deleteBankTransaction(@RequestBody BankTransaction transaction) {
        HttpHeaders headers = new HttpHeaders();

        try {

           BankTransaction bankTransaction = findBankTransaction(transaction);
           if (bankTransaction != null) {
               bankTransactionService.deleteBankTransaction(bankTransaction);
               headers.set("success", "la transaccion se a borrado con exito");
               return new ResponseEntity<String>(headers, HttpStatus.OK);

           }else {
               headers.set("error", "no existe el archivo solicitado");
               return new ResponseEntity<String>(headers, HttpStatus.CONFLICT);

           }

        }catch (Error e){
            headers.set("error", "error al conectar a la base de datos");
            return new ResponseEntity<String>(headers, HttpStatus.CONFLICT);
        }
    }


     //--------------------Search for Bank Transaction by reference and idBank------------------

    BankTransaction findBankTransaction(BankTransaction bankTransaction) {
        return bankTransactionService.findByReferenceAndByBankId(bankTransaction.getReference(), bankTransaction.getBank().getId());
    }


    //---------------------------Save Bank Transaction ---------------------------------

       public ResponseEntity<String> saveBankTransaction(BankTransaction bankTransaction) {

        HttpHeaders headers = new HttpHeaders();
        try {

            bankTransactionService.save(bankTransaction);
            headers.set("success", "transaction grabada con exito");
            return new ResponseEntity<String>(headers, HttpStatus.CREATED);

        } catch (Error e) {

            headers.set("error", "error al gragar datos");
            return new ResponseEntity<String>(headers, HttpStatus.CONFLICT);

        }
    }


}


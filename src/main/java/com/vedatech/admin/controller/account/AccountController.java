package com.vedatech.admin.controller.account;


import com.vedatech.admin.dao.account.AccountTypeDao;
import com.vedatech.admin.model.bank.AccountingType;
import com.vedatech.admin.service.account.AccountingTypeServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountingTypeServcie accountNameService;

    //-------------------Retrieve All Bank Accounts--------------------------------------------------------

    @RequestMapping(value = "/getAllAccounts/", method = RequestMethod.GET)
    public ResponseEntity<List<AccountingType>> listAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        List<AccountingType> accountNames = accountNameService.findAllAccountName();

        if (accountNames.isEmpty()) {
            headers.set("error", "no existen cuentas bancarias");
            return new ResponseEntity<List<AccountingType>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }


        return new ResponseEntity<List<AccountingType>>(accountNames, HttpStatus.OK);
    }

    @GetMapping(value = "/load-accounting-type/{term}", produces = { "application/json" })
    public @ResponseBody List<AccountingType> cargarAccountingType(@PathVariable String term) {
        return accountNameService.findByNombre(term);
    }


}

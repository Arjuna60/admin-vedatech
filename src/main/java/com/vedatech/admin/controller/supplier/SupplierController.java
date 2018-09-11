package com.vedatech.admin.controller.supplier;


import com.vedatech.admin.model.supplier.Supplier;
import com.vedatech.admin.service.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    //-------------------Retrieve All Bank Accounts--------------------------------------------------------

    @RequestMapping(value = "/getAllSuppliers/", method = RequestMethod.GET)
    public ResponseEntity<List<Supplier>> listAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        List<Supplier> suppliers = supplierService.findAllSuppliers();
        List<String> stringList = new ArrayList<>();

        stringList.add("Bank 1");
        stringList.add("Bank 2");

        if (suppliers.isEmpty()) {
            headers.set("error", "no existen cuentas bancarias");
            return new ResponseEntity<List<Supplier>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }


        return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
    }

}

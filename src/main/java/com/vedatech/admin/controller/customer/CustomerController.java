package com.vedatech.admin.controller.customer;

import com.vedatech.admin.model.customer.Customer;
import com.vedatech.admin.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //-------------------Retrieve All Customer Accounts--------------------------------------------------------

    @RequestMapping(value = "/getAllCustomers/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        List<Customer> customers = customerService.findAllCustomers();
        List<String> stringList = new ArrayList<>();

        stringList.add("Bank 1");
        stringList.add("Bank 2");

        if (customers.isEmpty()) {
            headers.set("error", "no existen Clientes");
            return new ResponseEntity<List<Customer>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }


        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

}

package com.vedatech.admin.controller.supplier;

import com.vedatech.admin.model.bank.BankTransaction;
import com.vedatech.admin.model.supplier.Invoice;
import com.vedatech.admin.service.supplier.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;


    //-------------------Create a Transaction--------------------------------------------------------

    @PostMapping(value = "/add-invoice")
    public ResponseEntity<String> createInvoice(@RequestBody Invoice invoice, UriComponentsBuilder ucBuilder) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        HttpHeaders headers = new HttpHeaders();

        if (findInvoice(invoice) != null) {
            headers.set("error", "la referencia ya existe");
            return new ResponseEntity<String>(headers, HttpStatus.CONFLICT);
        }
        return saveInvoice(invoice);

    }

    //--------------------Search for Bank Transaction by reference and idBank------------------

    Invoice findInvoice(Invoice invoice) {
        return invoiceService.findInvoiceByInvoiceNumber(invoice.getInvoiceNumber());
    }


    //---------------------------Save Bank Transaction ---------------------------------

    public ResponseEntity<String> saveInvoice(Invoice invoice) {

        HttpHeaders headers = new HttpHeaders();
        try {

            invoiceService.saveInvoice(invoice);
            headers.set("success", "transaction grabada con exito");
            return new ResponseEntity<String>(headers, HttpStatus.CREATED);

        } catch (Error e) {

            headers.set("error", "error al gragar datos");
            return new ResponseEntity<String>(headers, HttpStatus.CONFLICT);

        }
    }


}

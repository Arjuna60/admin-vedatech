package com.vedatech.admin.controller;

import com.vedatech.admin.dao.account.AccountTypeDao;
import com.vedatech.admin.model.bank.AccountingType;
import com.vedatech.admin.model.invoice.Comprobante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RestController
public class MainControl {

    @Autowired
    AccountTypeDao accountTypeDao;

    @GetMapping(value = "/")
    public ResponseEntity<String> MessageControl() throws JAXBException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("message", "Server is work success");

        JAXBContext context = JAXBContext.newInstance(Comprobante.class);
        File cfdi = new File("C:/SAT2/ANT021004RI7_PUHS6505319L9_764.xml");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        Comprobante unmarshal = (Comprobante) unmarshaller.unmarshal(cfdi);
        System.out.println(unmarshal.getEmisor().getNombre());
        System.out.println(unmarshal.getReceptor().getNombre());
        System.out.println(unmarshal.getSubTotal());
        System.out.println(unmarshal.getTotal());
        System.out.println(unmarshal.getConceptos().getConcepto());

        List<Comprobante.Conceptos.Concepto> conceptoList =  unmarshal.getConceptos().getConcepto();

        for (Comprobante.Conceptos.Concepto co : conceptoList) {

            System.out.println(co.getDescripcion());
            System.out.println(co.getCantidad());
            System.out.println(co.getImporte());


        }


        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

    @GetMapping(value = "/api/list")
    public ResponseEntity<List<AccountingType>> getAccountingType() {
        List<AccountingType> allAccounts = (List<AccountingType>) accountTypeDao.findAll();

        return new ResponseEntity<List<AccountingType>> ( allAccounts, HttpStatus.OK);
    }
}

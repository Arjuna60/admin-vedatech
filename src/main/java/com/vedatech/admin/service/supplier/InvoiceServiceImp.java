package com.vedatech.admin.service.supplier;

import com.vedatech.admin.dao.supplierDao.InvoiceDao;
import com.vedatech.admin.model.supplier.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class InvoiceServiceImp implements InvoiceService {

    @Autowired
    InvoiceDao invoiceDao;

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceDao.save(invoice);
    }

    @Override
    public Invoice findInvoiceByInvoiceNumber(Long invoiceNumber) {
        return invoiceDao.findInvoiceByInvoiceNumber(invoiceNumber);
    }
}

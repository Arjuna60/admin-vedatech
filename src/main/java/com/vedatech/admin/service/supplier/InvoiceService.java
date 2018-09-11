package com.vedatech.admin.service.supplier;

import com.vedatech.admin.model.supplier.Invoice;

public interface InvoiceService {

     Invoice saveInvoice(Invoice invoice);
     Invoice findInvoiceByInvoiceNumber(Long invoiceNumber);

}

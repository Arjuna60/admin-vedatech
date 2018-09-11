package com.vedatech.admin.dao.supplierDao;

import com.vedatech.admin.model.supplier.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceDao extends CrudRepository<Invoice, Long> {

    Invoice findInvoiceByInvoiceNumber(Long invoiceNumber);

}

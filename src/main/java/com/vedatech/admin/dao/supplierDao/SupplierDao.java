package com.vedatech.admin.dao.supplierDao;

import com.vedatech.admin.model.supplier.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierDao extends CrudRepository<Supplier, Long> {

}

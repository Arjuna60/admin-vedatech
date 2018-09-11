package com.vedatech.admin.service.supplier;

import com.vedatech.admin.dao.supplierDao.SupplierDao;
import com.vedatech.admin.model.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SupplierServiceImp implements SupplierService {

    @Autowired
    SupplierDao supplierDao;

    @Override
    public List<Supplier> findAllSuppliers() {
        return (List<Supplier>) supplierDao.findAll();
    }
}

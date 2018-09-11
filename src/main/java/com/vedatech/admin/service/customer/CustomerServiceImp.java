package com.vedatech.admin.service.customer;

import com.vedatech.admin.dao.customerDao.CustomerDao;
import com.vedatech.admin.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public List<Customer> findAllCustomers() {
        return (List<Customer>) customerDao.findAll();
    }
}

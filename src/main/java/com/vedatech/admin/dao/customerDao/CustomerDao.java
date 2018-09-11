package com.vedatech.admin.dao.customerDao;

import com.vedatech.admin.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Long> {
}

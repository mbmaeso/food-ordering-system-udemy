package com.food.ordering.system.service.dataaccess.customer.mapper;

import com.food.ordering.system.domain.valueobject.CustomerId;
import com.food.ordering.system.order.service.domain.entity.Customer;
import com.food.ordering.system.service.dataaccess.customer.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {
	public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
		return new Customer(new CustomerId(customerEntity.getId()));
	}
}

package com.bakdev.ebankingbackend.mappers;

import com.bakdev.ebankingbackend.dtos.CustomerDTO;
import com.bakdev.ebankingbackend.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {
    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer , customerDTO); // copier les données customer vers costomerDTO
        return customerDTO;
    }public Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO , customer ); // copier les données costomerDTO vers customer
        return customer;
    }
}

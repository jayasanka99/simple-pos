package com.examplepractice.demo.service;

import com.examplepractice.demo.dto.request.CustomerSaveDTO;
import com.examplepractice.demo.dto.request.CustomerUpdateDTO;
import com.examplepractice.demo.dto.response.CustomerDTO;

import java.util.List;


public interface CustomerService {
    String saveCustomer(CustomerSaveDTO customerSaveDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerSaveDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomerByActive(boolean activeState);
}

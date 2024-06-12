package com.examplepractice.demo.service.impl;

import com.examplepractice.demo.dto.request.CustomerSaveDTO;
import com.examplepractice.demo.dto.request.CustomerUpdateDTO;
import com.examplepractice.demo.dto.response.CustomerDTO;
import com.examplepractice.demo.entity.Customer;
import com.examplepractice.demo.exception.NotFoundException;
import com.examplepractice.demo.repo.CustomerRepo;
import com.examplepractice.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {

    private final CustomerRepo customerRepo;
    private final ModelMapper modelMapper;


    @Override
    public String saveCustomer(CustomerSaveDTO customerSaveDTO) {
        Customer customer = modelMapper.map(customerSaveDTO, Customer.class);
        if (!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
            return "Customer saved successfully";
        } else {
            throw new NotFoundException("Customer already exists");
        }
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.findById(customerUpdateDTO.getCustomerId()).get();

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + " Updated Successfully";

        } else {
            throw new NotFoundException("Customer Not found");
        }
    }

    @Override
    public CustomerSaveDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.findById(customerId).get();
            return modelMapper.map(customer, CustomerSaveDTO.class);

        } else {
            throw new NotFoundException("Customer Not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = (List<Customer>) customerRepo.findAll();

        if (!customers.isEmpty()) {
            return modelMapper.map(customers, new TypeToken<List<CustomerDTO>>() {
            }.getType());
        } else {
            throw new NotFoundException("No customers found");
        }

    }

    @Override
    public String deleteCustomer(int customerId) {
        if (!customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "Customer delete successfully";
        } else {
            throw new NotFoundException("No customer found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomerByActive(boolean activeState) {
        List<Customer> customers = customerRepo.findAllByActiveStateEquals(activeState);
        if (!customers.isEmpty()) {
            return modelMapper.map(customers, new TypeToken<List<CustomerDTO>>() {
            }.getType());
        } else {
            throw new NotFoundException("No Active customers found");
        }
    }


}



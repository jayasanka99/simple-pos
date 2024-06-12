package com.examplepractice.demo.controller;

import com.examplepractice.demo.dto.request.CustomerSaveDTO;
import com.examplepractice.demo.dto.request.CustomerUpdateDTO;
import com.examplepractice.demo.dto.response.CustomerDTO;
import com.examplepractice.demo.service.CustomerService;
import com.examplepractice.demo.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO) {
        customerService.saveCustomer(customerSaveDTO);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success","Customer Saved Successfully"),
                HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        customerService.updateCustomer(customerUpdateDTO);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success","Customer Updated Successfully"),
                HttpStatus.OK);
    }

    @GetMapping(value = "/get-by-id", params = "id")
    public ResponseEntity<StandardResponse> getCustomerById(@RequestParam(value = "id") int CustomerId) {
        CustomerSaveDTO customerById =customerService.getCustomerById(CustomerId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",customerById),
                HttpStatus.OK);
    }

    @GetMapping("/get-all-customer")
    public ResponseEntity<StandardResponse> getAllCustomer() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",allCustomers),
                 HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete", params = "id")
    public ResponseEntity<StandardResponse> deleteCustomer(@RequestParam(value = "id") int CustomerId) {
        customerService.deleteCustomer(CustomerId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success","Customer Delete Successfully"),
                HttpStatus.OK);
    }

    @GetMapping(path = "/get-all-customer-by-active/{state}")
    public ResponseEntity<StandardResponse> getAllCustomerByActive(@PathVariable(value = "state") boolean activeState) {
        List<CustomerDTO> getAllCustomerByActive = customerService.getAllCustomerByActive(activeState);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",getAllCustomerByActive),
                HttpStatus.OK);
    }

}

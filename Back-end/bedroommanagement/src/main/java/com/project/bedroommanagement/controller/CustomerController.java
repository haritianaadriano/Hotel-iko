package com.project.bedroommanagement.controller;

import com.project.bedroommanagement.model.Customer;
import com.project.bedroommanagement.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(
            @RequestParam(name = "page", required = false)Long page,
            @RequestParam(name = "page_size", required = false)Long pageSize,
            @RequestParam(name = "name", required = false)String name,
            @RequestParam(name = "last_name", required = false)String lastName,
            @RequestParam(name = "email", required = false)String email,
            @RequestParam(name = "phone", required = false)String phone
    ){
        return customerService.redirectingRequest(page, pageSize, name, lastName, email, phone);
    }

    @PostMapping("/customer")
    public Customer insertNewCustomer(@RequestBody Customer newCustomer){
        return customerService.insertNewCustomer(newCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable(name = "id") Long id){
        return customerService.deleteCustomer(id);
    }

    @PutMapping("/customer/{id}")
    public Customer putUpdateCustomer(
            @PathVariable(name = "id")Long id,
            @RequestBody Customer newCustomer
    ){
        return customerService.putUpdateCustomer(id, newCustomer);
    }
}

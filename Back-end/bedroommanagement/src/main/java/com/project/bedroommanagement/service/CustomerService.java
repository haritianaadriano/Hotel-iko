package com.project.bedroommanagement.service;

import com.project.bedroommanagement.model.Customer;
import com.project.bedroommanagement.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    //GET -> all customer with specific page
    public List<Customer> getAllCustomer (Long page, Long pageSize){
        if(page != null && pageSize != null){
            Pageable pageable = PageRequest.of(Math.toIntExact(page - 1), Math.toIntExact(pageSize));
            return customerRepository.findAll(pageable).toList();
        }else {
            return customerRepository.findAll();
        }
    }

    //GET -> or search a customer with a character specific
    public List<Customer> getSpecificCustomer(String name, String lastName, String email, String phone){
        if(name != null && lastName == null && email == null && phone == null){
            return customerRepository.findByName(name);
        }else if(name == null && lastName != null && email == null && phone == null){
            return customerRepository.findByLastName(lastName);
        } else if (name == null && lastName == null && email != null && phone == null) {
            return customerRepository.findByEmail(email);
        } else {
            return customerRepository.findByPhone(phone);
        }
    }

    //GET -> redirecting request
    /**
     * this function has a role of redirecting the request in the browser to get the responses who the client want to have
     * @param page page of the response if exist
     * @param pageSize pageSize of the response
     * @param name name of customer to help the searching
     * @param lastName last-name of the customer to help the searching
     * @param email email of the customer to search the contact-in-line
     * @param phone phone number of the customer
     * @return List of customer
     */
    public List<Customer> redirectingRequest(Long page, Long pageSize, String name, String lastName, String email, String phone){
        if(page == null && pageSize == null || lastName != null || name != null || email != null || phone != null){
            return this.getSpecificCustomer(name, lastName, email, phone);
        }else{
            return this.getAllCustomer(page, pageSize);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Post -> to insert a new customer
    public Customer insertNewCustomer(Customer newCustomer){
        return customerRepository.save(newCustomer);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Delete -> to delete one customer
    public String deleteCustomer(Long id){
        customerRepository.deleteById(id);
        return "delete successfully";
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Put -> Mapping to update The customer
    public Customer putUpdateCustomer(Long id, Customer newCustomer){
        Optional<Customer> customerOptional = customerRepository.findById(id);
        Customer customerToChange;
        if(customerOptional.isPresent()){
            customerToChange = customerOptional.get();
        }else {
            throw new NullPointerException("not found");
        }

        customerToChange.setName(newCustomer.getName());
        customerToChange.setLastName(newCustomer.getLastName());
        customerToChange.setPhone(newCustomer.getPhone());
        customerToChange.setEmail(newCustomer.getEmail());
        customerRepository.save(customerToChange);
        return customerToChange;
    }
}

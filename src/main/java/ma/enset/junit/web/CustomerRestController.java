package ma.enset.junit.web;

import ma.enset.junit.entities.Customer;

import ma.enset.junit.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return customerService.getAccount(id);
    }
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getAccounts();
    }
}

package ma.enset.junit.services;

import ma.enset.junit.entities.Account;
import ma.enset.junit.entities.Customer;
import ma.enset.junit.repository.AccountRepository;
import ma.enset.junit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer getAccount(Long id){
        return  customerRepository.findById(id).get();
    }

    public List<Customer> getAccounts(){
        return customerRepository.findAll();
    }


}

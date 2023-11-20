package ma.enset.junit.services;

import ma.enset.junit.entities.Account;
import ma.enset.junit.entities.Customer;
import ma.enset.junit.repository.AccountRepository;
import ma.enset.junit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;


    public Account getAccount(String id){
        return  accountRepository.findById(id).get();
    }


    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByCustomerId(Long id){
        List<Customer> customers = customerRepository.findAllById(Collections.singleton(id));
        List<Account> accounts=new ArrayList<>();
        customers.forEach(customer -> {
            accounts.addAll(customer.getAccounts());
        });
      return accounts;
    }


}

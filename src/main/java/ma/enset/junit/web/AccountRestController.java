package ma.enset.junit.web;

import ma.enset.junit.entities.Account;
import ma.enset.junit.entities.Customer;
import ma.enset.junit.services.AccountService;
import ma.enset.junit.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class AccountRestController {
    @Autowired
    AccountService accountService;

    @GetMapping("/accounts/{id}")
    public Account getCustomer(@PathVariable("id") String id){
        return accountService.getAccount(id);
    }
    @GetMapping("/accounts")
    public List<Account> getCustomers(){
        return accountService.getAccounts();
    }
}

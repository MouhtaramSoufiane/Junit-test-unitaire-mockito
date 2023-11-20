package ma.enset.junit.Test;

import ma.enset.junit.entities.Account;
import ma.enset.junit.entities.Customer;
import ma.enset.junit.repository.AccountRepository;
import ma.enset.junit.repository.CustomerRepository;
import ma.enset.junit.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.COLLECTION;

import java.util.List;
import java.util.UUID;


@DataJpaTest
public class DaoTestUnit {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;

    // Traitement avant testing
    @BeforeEach
    void setUp(){

        List<String> customers = List.of("soufiane", "Yassine", "Mohamed", "Reda");

        customers.forEach(s->{
            Customer customer=Customer.builder()
                    .name(s)
                    .email(s+"@gmail.com")
                    .build();
            customerRepository.save(customer);

        });

        List<Customer> customers1 = customerRepository.findAll();
        for (Customer customer : customers1) {
            for (int i = 0; i < 4; i++) {
                Account account = Account.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(Math.random() * 100000)
                        .currency(Math.random() > 0.5 ? "MAD" : "USA")
                        .customer(customer)
                        .build();
                accountRepository.save(account);

            }

            customer.setAccounts(accountRepository.findAll());
            customerRepository.save(customer);

        }


    }


    @Test
    @DisplayName("Should return 16 Accounts")

    // Test method
    public void findAccounts(){

        List<Account> accounts = accountRepository.findAll();
        assertThat(accounts.size()).isEqualTo(16);


    }
    @Test
    @DisplayName("Should return 4 Customers")

    // Test method
    public void findCustomers(){

        List<Customer> customers = customerRepository.findAll();
        assertThat(customers.size()).isEqualTo(4);


    }


}

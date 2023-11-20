package ma.enset.junit;

import ma.enset.junit.entities.Account;
import ma.enset.junit.entities.Customer;
import ma.enset.junit.repository.AccountRepository;
import ma.enset.junit.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class JunitTestUnitairesApplication {

    public static void main(String[] args) {

        SpringApplication.run(JunitTestUnitairesApplication.class, args);



    }

//    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, AccountRepository accountRepository){
        return args -> {
            List<String> list = List.of("Soufiane", "Yassine", "Mohamed", "Reda");

            list.forEach(name->{
                Customer customer=Customer.builder()
                        .name(name)
                        .email(name+"@gmail.com")
                        .build();
                customerRepository.save(customer);

            });

            List<Customer> customers = customerRepository.findAll();
            for (Customer customer : customers) {
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

        };

    }

}

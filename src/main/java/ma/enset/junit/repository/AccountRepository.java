package ma.enset.junit.repository;

import ma.enset.junit.entities.Account;
import ma.enset.junit.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AccountRepository extends JpaRepository<Account,String> {

}

package ma.enset.junit.Mappers;

import ma.enset.junit.DTOs.AccountRequestDTO;
import ma.enset.junit.DTOs.CustomerRequestDTO;
import ma.enset.junit.entities.Account;
import ma.enset.junit.entities.Customer;

public interface CustomerMappers {
    CustomerRequestDTO from(Customer customer);
    Customer from(CustomerRequestDTO requestDTO);
}

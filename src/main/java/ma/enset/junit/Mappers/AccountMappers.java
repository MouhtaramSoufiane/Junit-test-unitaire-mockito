package ma.enset.junit.Mappers;

import ma.enset.junit.DTOs.AccountRequestDTO;
import ma.enset.junit.entities.Account;

public interface AccountMappers {
    AccountRequestDTO from(Account account);
    Account from(AccountRequestDTO requestDTO);
}

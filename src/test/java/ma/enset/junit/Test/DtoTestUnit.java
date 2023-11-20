package ma.enset.junit.Test;


import ma.enset.junit.DTOs.AccountRequestDTO;
import ma.enset.junit.DTOs.CustomerRequestDTO;
import ma.enset.junit.Mappers.AccountMappersImpl;
import ma.enset.junit.entities.Account;
import ma.enset.junit.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DtoTestUnit {
    @InjectMocks
    AccountMappersImpl accountMappers;
    @Mock
    ModelMapper modelMapper;

    Account account;
    AccountRequestDTO accountRequestDTO;

    @BeforeEach
    void init(){
        account= Account.builder()
                .currency("MAD")
                .balance(120000.)
                .accountId("account1")
                .customer(new Customer(1L,"Soufiane","soufianerespect@gmail.com", List.of(new Account("acc1","MAD",100.,null))))

                .build();

        accountRequestDTO=AccountRequestDTO.builder()
                .accountId("account1")
                .balance(120000.)
                .currency("MAD")
                .requestDTO(new CustomerRequestDTO(1L,"Soufiane","soufianerespect@gmail.com",List.of(new AccountRequestDTO("acc1","MAD",100.,null))))
                .build();
    }


    @Test
    @DisplayName("Should be transfer Account to an AccountDTO ")
    void fromAccountToAccountRequestDTO(){
        when(modelMapper.map(account,AccountRequestDTO.class)).thenReturn(accountRequestDTO);
        AccountRequestDTO result = accountMappers.from(account);
        var expected=accountRequestDTO;
        assertThat(result.getAccountId()).isEqualTo(expected.getAccountId());
        assertThat(result.getBalance()).isEqualTo(expected.getBalance());
        assertThat(result.getCurrency()).isEqualTo(expected.getCurrency());

    }


}

package ma.enset.junit.Mappers;

import jakarta.annotation.PostConstruct;
import ma.enset.junit.DTOs.AccountRequestDTO;
import ma.enset.junit.entities.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountMappersImpl implements AccountMappers {
    private ModelMapper modelMapper;
    @PostConstruct
    void init(){
        modelMapper=new ModelMapper();
    }
    @Override
    public AccountRequestDTO from(Account account) {
        return modelMapper.map(account,AccountRequestDTO.class);
    }

    @Override
    public Account from(AccountRequestDTO requestDTO) {
        return modelMapper.map(requestDTO,Account.class);
    }
}

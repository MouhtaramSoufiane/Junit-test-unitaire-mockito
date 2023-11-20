package ma.enset.junit.Mappers;

import jakarta.annotation.PostConstruct;
import ma.enset.junit.DTOs.CustomerRequestDTO;
import ma.enset.junit.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerMappersImpl implements CustomerMappers {
    private ModelMapper modelMapper;
    @PostConstruct
    void init(){
        modelMapper=new ModelMapper();
    }
    @Override
    public CustomerRequestDTO from(Customer customer) {
        return modelMapper.map(customer,CustomerRequestDTO.class);
    }

    @Override
    public Customer from(CustomerRequestDTO requestDTO) {
        return modelMapper.map(requestDTO,Customer.class);
    }
}

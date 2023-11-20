package ma.enset.junit.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AccountRequestDTO {
    private String accountId;
    private String currency;
    private Double balance;
    private CustomerRequestDTO requestDTO;
}

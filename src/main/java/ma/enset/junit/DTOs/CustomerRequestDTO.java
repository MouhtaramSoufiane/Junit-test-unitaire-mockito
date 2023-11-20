package ma.enset.junit.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CustomerRequestDTO {
    private Long id;
    private String name;
    private String email;
    List<AccountRequestDTO> accounts;
}

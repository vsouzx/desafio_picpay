package br.com.souzadev.picpay_desafio.dto;

import br.com.souzadev.picpay_desafio.enums.ClientTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequest {

    private String name;
    private String cpf;
    private String email;
    private String password;
    private ClientTypeEnum type;
    private BigDecimal balance;

}

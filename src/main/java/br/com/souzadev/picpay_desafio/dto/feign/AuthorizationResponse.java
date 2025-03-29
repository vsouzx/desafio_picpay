package br.com.souzadev.picpay_desafio.dto.feign;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private DataResponse data;
}

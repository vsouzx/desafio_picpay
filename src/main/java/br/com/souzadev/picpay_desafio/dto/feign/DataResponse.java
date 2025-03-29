package br.com.souzadev.picpay_desafio.dto.feign;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {

    @JsonProperty("authorization")
    private Boolean authorization;

}

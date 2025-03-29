package br.com.souzadev.picpay_desafio.feign;

import br.com.souzadev.picpay_desafio.config.feign.FeignConfiguration;
import br.com.souzadev.picpay_desafio.dto.feign.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AuthorizationClient", url = "https://util.devi.tools/api", configuration = FeignConfiguration.class)
public interface AuthorizationClient {

    @GetMapping(value = "/v2/authorize")
    AuthorizationResponse getAuthorization();

}

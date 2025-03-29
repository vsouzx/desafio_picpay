package br.com.souzadev.picpay_desafio.controller;

import br.com.souzadev.picpay_desafio.dto.TransferRequest;
import br.com.souzadev.picpay_desafio.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTransfer(@RequestBody TransferRequest request) throws Exception{
        transferService.createTransfer(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

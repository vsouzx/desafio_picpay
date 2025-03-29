package br.com.souzadev.picpay_desafio.controller;

import br.com.souzadev.picpay_desafio.dto.UsersRequest;
import br.com.souzadev.picpay_desafio.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UsersRequest request) throws Exception{
        usersService.createUser(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

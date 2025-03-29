package br.com.souzadev.picpay_desafio.service;

import br.com.souzadev.picpay_desafio.database.model.Users;
import br.com.souzadev.picpay_desafio.database.repository.UserRepository;
import br.com.souzadev.picpay_desafio.dto.UsersRequest;
import br.com.souzadev.picpay_desafio.handler.exceptions.CpfAlreadyExistsException;
import br.com.souzadev.picpay_desafio.handler.exceptions.EmailAlreadyExistsException;
import br.com.souzadev.picpay_desafio.handler.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(UsersRequest request) throws Exception{
        validateEmailAndCpf(request);

        userRepository.save(Users.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .balance(request.getBalance())
                .type(request.getType())
                .build());
    }

    public Users findById(Integer id) throws NotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Usuario nao encontrado: %s", id)));
    }

    public void save(Users user){
        userRepository.save(user);
    }

    private void validateEmailAndCpf(UsersRequest request) throws Exception{
        Users user = userRepository.findByCpf(request.getCpf()).orElse(null);
        if(user != null) throw new CpfAlreadyExistsException(request.getCpf());

        user = userRepository.findByEmail(request.getEmail()).orElse(null);
        if(user != null) throw new EmailAlreadyExistsException(request.getEmail());
    }
}

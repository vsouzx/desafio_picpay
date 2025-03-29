package br.com.souzadev.picpay_desafio.database.repository;

import br.com.souzadev.picpay_desafio.database.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);

    Optional<Users> findByCpf(String cpf);
}

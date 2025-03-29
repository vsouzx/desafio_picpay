package br.com.souzadev.picpay_desafio.database.repository;

import br.com.souzadev.picpay_desafio.database.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
}

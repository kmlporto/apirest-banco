package com.kamila.banco.repository;

import com.kamila.banco.entity.Conta;
import com.kamila.banco.entity.Pessoa;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends GenericRepository<Conta>{
    boolean existsByPessoa(Pessoa pessoa);
}

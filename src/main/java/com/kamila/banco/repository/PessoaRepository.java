package com.kamila.banco.repository;

import com.kamila.banco.entity.Pessoa;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends GenericRepository<Pessoa> {
    boolean existsByCpf(String cpf);
}

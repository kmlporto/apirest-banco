package com.kamila.banco.servicos;

import com.kamila.banco.entity.Pessoa;
import com.kamila.banco.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.security.InvalidParameterException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;

    public Pessoa salvar(Pessoa pessoa){
        Optional.ofNullable(pessoa).orElseThrow(InvalidParameterException::new);
        return repository.save(pessoa);
    }

    public Pessoa consultar(Long id){
        Optional.ofNullable(id).orElseThrow(InvalidParameterException::new);
        return repository.findById(id).orElseThrow(NoResultException::new);
    }

    public boolean existsByCpf(String cpf){
        return repository.existsByCpf(cpf);
    }
}


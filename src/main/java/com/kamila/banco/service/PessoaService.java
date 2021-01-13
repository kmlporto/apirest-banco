package com.kamila.banco.service;

import com.kamila.banco.entity.Pessoa;
import com.kamila.banco.error.BadRequestException;
import com.kamila.banco.error.NotFoundException;
import com.kamila.banco.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.security.InvalidParameterException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa){
        existsByCpf(pessoa.getCpf());
        Optional.ofNullable(pessoa).orElseThrow(InvalidParameterException::new);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa consultar(Long id){
        existsById(id);
        return pessoaRepository.findById(id).orElseThrow(NoResultException::new);
    }

    public Pessoa alterar(Long id, Pessoa pessoaUpdate){
        Pessoa pessoa = consultar(id);
        pessoa.setEmail(pessoaUpdate.getEmail());

        return pessoaRepository.save(pessoa);
    }

    public void existsByCpf(String cpf){
        if(pessoaRepository.existsByCpf(cpf)){
            throw new BadRequestException("Já existe pessoa com este CPF");
        }
    }

    public void existsById(Long id){
        Optional.ofNullable(id).orElseThrow(InvalidParameterException::new);
        if (!pessoaRepository.existsById(id)){
            throw new NotFoundException("Pessoa não encontrada");
        }
    }
}


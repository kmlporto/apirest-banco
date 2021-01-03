package com.kamila.banco.service;

import com.kamila.banco.entity.Conta;
import com.kamila.banco.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.security.InvalidParameterException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;
    private final PessoaService pessoaService;

    public Conta consultar(Long id) {
        Optional.ofNullable(id).orElseThrow(InvalidParameterException::new);
        return contaRepository.findById(id).orElseThrow(NoResultException::new);
    }

    public Conta salvar(Conta conta){
        pessoaService.consultar(conta.getPessoa().getId());
        Optional.ofNullable(conta).orElseThrow(InvalidParameterException::new);
        return contaRepository.save(conta);
    }
}

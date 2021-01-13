package com.kamila.banco.service;

import com.kamila.banco.entity.Conta;
import com.kamila.banco.error.NotFoundException;
import com.kamila.banco.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;
    private final PessoaService pessoaService;

    public Conta consultar(Long id) {
        existsById(id);
        return contaRepository.findById(id).get();
    }

    public Conta salvar(Conta conta){
        Optional.ofNullable(conta).orElseThrow(InvalidParameterException::new);
        pessoaService.existsById(conta.getPessoa().getId());

        return contaRepository.save(conta);
    }

    public void existsById(Long id){
        Optional.ofNullable(id).orElseThrow(InvalidParameterException::new);
        if (!contaRepository.existsById(id)){
            throw new NotFoundException("Conta não encontrada");
        }
    }
}

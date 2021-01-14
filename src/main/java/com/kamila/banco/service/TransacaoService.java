package com.kamila.banco.service;

import com.kamila.banco.entity.Conta;
import com.kamila.banco.entity.Transacao;
import com.kamila.banco.enums.TipoTransacao;
import com.kamila.banco.error.BadRequestException;
import com.kamila.banco.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    private final ContaService contaService;

    public Transacao transacao(Long idConta, Transacao transacao){
        Conta conta = contaService.consultar(idConta);
        transacao.setConta(conta);
        transacao.setDataTransacao(LocalDate.now());
        alterarSaldo(conta, transacao);

        return transacaoRepository.save(transacao);
    }

    public void alterarSaldo(Conta conta, Transacao transacao){
        if (transacao.getTipoTransacao().equals(TipoTransacao.DEPOSITO)){
            conta.setSaldo(conta.getSaldo().add(transacao.getValor()));
        }else{
            if(conta.getSaldo().compareTo(transacao.getValor()) < 0){
                throw new BadRequestException("Conta não possui saldo para saque");
            }
            conta.setSaldo(conta.getSaldo().subtract(transacao.getValor()));
        }
    }

    public List<Transacao> consultarExtrado(Long idConta, LocalDate dataInicio, LocalDate dataFim){
        contaService.existsById(idConta);
        return listarTransacoes(idConta, dataInicio, dataFim);
    }

    public List<Transacao> listarTransacoes(Long idConta, LocalDate dataInicio, LocalDate dataFim){
        return transacaoRepository.findAllByConta_IdAndDataTransacaoBetween(idConta, dataInicio, dataFim);
    }
}

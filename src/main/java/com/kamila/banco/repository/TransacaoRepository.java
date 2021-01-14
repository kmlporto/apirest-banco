package com.kamila.banco.repository;

import com.kamila.banco.entity.Transacao;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransacaoRepository extends GenericRepository<Transacao>{
    List<Transacao>findAllByConta_IdAndDataTransacaoBetween(Long id, LocalDate dataInicio, LocalDate dataFim);
}

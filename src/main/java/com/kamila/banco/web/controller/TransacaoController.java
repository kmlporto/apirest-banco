package com.kamila.banco.web.controller;

import com.kamila.banco.converter.TransacaoMapper;
import com.kamila.banco.entity.Transacao;
import com.kamila.banco.enums.TipoTransacao;
import com.kamila.banco.service.TransacaoService;
import com.kamila.banco.util.Path;
import com.kamila.banco.web.dto.persist.TransacaoPersist;
import com.kamila.banco.web.dto.response.TransacaoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = Path.CONTA_TRANSACAO)
@RestController
public class TransacaoController {

    private final TransacaoService transacaoService;
    private final TransacaoMapper transacaoMapper;

    @PostMapping(value = Path.SAQUE)
    public ResponseEntity<TransacaoResponse> saque(
            @PathVariable("id") Long id,
            @Valid @RequestBody TransacaoPersist transacaoPersist){
        Transacao transacao = transacaoMapper.persistToEntity(transacaoPersist);
        transacao.setTipoTransacao(TipoTransacao.SAQUE);

        transacao = transacaoService.transacao(id, transacao);
        TransacaoResponse response = transacaoMapper.entityToResponse(transacao);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = Path.DEPOSITO)
    public ResponseEntity<TransacaoResponse> deposito(
            @PathVariable("id") Long id,
            @Valid @RequestBody TransacaoPersist transacaoPersist){
        Transacao transacao = transacaoMapper.persistToEntity(transacaoPersist);
        transacao.setTipoTransacao(TipoTransacao.DEPOSITO);

        transacao = transacaoService.transacao(id, transacao);
        TransacaoResponse response = transacaoMapper.entityToResponse(transacao);
        return ResponseEntity.ok().body(response);
    }
}

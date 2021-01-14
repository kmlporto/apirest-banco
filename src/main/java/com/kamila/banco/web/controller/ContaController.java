package com.kamila.banco.web.controller;

import com.kamila.banco.converter.ContaMapper;
import com.kamila.banco.converter.TransacaoMapper;
import com.kamila.banco.entity.Transacao;
import com.kamila.banco.service.TransacaoService;
import com.kamila.banco.web.dto.persist.ContaPersist;
import com.kamila.banco.web.dto.request.ExtratoRequest;
import com.kamila.banco.web.dto.response.ContaResponse;
import com.kamila.banco.entity.Conta;
import com.kamila.banco.service.ContaService;
import com.kamila.banco.util.Path;
import com.kamila.banco.web.dto.response.ExtratoResponse;
import com.kamila.banco.web.dto.response.SaldoResponse;
import com.kamila.banco.web.dto.response.TransacaoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = Path.CONTA)
@RestController
public class ContaController {

    private final ContaService contaService;

    private final TransacaoService transacaoService;

    private final ContaMapper contaMapper;

    private final TransacaoMapper transacaoMapper;

    @GetMapping(value = Path.ID)
    public ResponseEntity<ContaResponse> consultar(@PathVariable("id")Long id){
        Conta conta = contaService.consultar(id);
        ContaResponse response = contaMapper.entityToResponse(conta);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ContaResponse> salvar(@Valid @RequestBody ContaPersist contaPersist){
        Conta conta = contaService.salvar(contaMapper.persitToEntity(contaPersist));
        ContaResponse response = contaMapper.entityToResponse(conta);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = Path.SALDO)
    public ResponseEntity<SaldoResponse> verificarSaldo(@PathVariable("id")Long id){
        BigDecimal saldo = contaService.consultarSaldo(id);
        SaldoResponse saldoResponse = new SaldoResponse(saldo);

        return ResponseEntity.ok().body(saldoResponse);
    }

    @GetMapping(value = Path.EXTRATO)
    public ResponseEntity<ExtratoResponse> verificarExtrato(@PathVariable("id")Long id, ExtratoRequest extratoRequest){
        List<Transacao> transacaos = transacaoService.consultarExtrado(id, extratoRequest.getDataInicio(), extratoRequest.getDataFim());
        List<TransacaoResponse> transacaoResponses = transacaoMapper.transacoesToTransacoesResponse(transacaos);
        ExtratoResponse response = ExtratoResponse.builder().transacoes(transacaoResponses).build();
        return ResponseEntity.ok().body(response);

    }
}

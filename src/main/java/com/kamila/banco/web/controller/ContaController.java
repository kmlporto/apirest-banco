package com.kamila.banco.web.controller;

import com.kamila.banco.converter.ContaMapper;
import com.kamila.banco.web.dto.persist.ContaPersist;
import com.kamila.banco.web.dto.response.ContaResponse;
import com.kamila.banco.entity.Conta;
import com.kamila.banco.service.ContaService;
import com.kamila.banco.util.Path;
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

@AllArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = Path.CONTA)
@RestController
public class ContaController {

    private final ContaService service;

    private final ContaMapper contaMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContaResponse> consultar(@PathVariable("id")Long id){
        Conta conta = service.consultar(id);
        ContaResponse response = contaMapper.entityToResponse(conta);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ContaResponse> salvar(@Valid @RequestBody ContaPersist contaPersist){
        Conta conta = service.salvar(contaMapper.persitToEntity(contaPersist));
        ContaResponse response = contaMapper.entityToResponse(conta);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

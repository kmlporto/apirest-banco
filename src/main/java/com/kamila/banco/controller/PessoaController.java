package com.kamila.banco.controller;

import com.kamila.banco.dto.persist.PessoaPersist;
import com.kamila.banco.dto.response.PessoaResponse;
import com.kamila.banco.entity.Pessoa;
import com.kamila.banco.service.PessoaService;
import com.kamila.banco.converter.Converter;
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
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = Path.PESSOA)
@RestController
public class PessoaController {

    private final PessoaService service;
    private final Converter converter;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaResponse> consultar(@PathVariable("id") Long id){
        Pessoa pessoa = service.consultar(id);
        PessoaResponse response = converter.map(pessoa, PessoaResponse.class);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> salvar(@Valid @RequestBody PessoaPersist pessoaPersist){
        Pessoa pessoa = service.salvar(converter.map(pessoaPersist, Pessoa.class));
        PessoaResponse response = converter.map(pessoa, PessoaResponse.class);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

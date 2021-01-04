package com.kamila.banco.controller;

import com.kamila.banco.converter.ContaMapper;
import com.kamila.banco.converter.PessoaMapper;
import com.kamila.banco.dto.persist.PessoaPersist;
import com.kamila.banco.dto.response.PessoaResponse;
import com.kamila.banco.entity.Pessoa;
import com.kamila.banco.service.PessoaService;
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

    private final PessoaMapper pessoaMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaResponse> consultar(@PathVariable("id") Long id){
        Pessoa pessoa = service.consultar(id);
        PessoaResponse response = pessoaMapper.entityToResponse(pessoa);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> salvar(@Valid @RequestBody PessoaPersist pessoaPersist){
        Pessoa pessoa = service.salvar(pessoaMapper.persitToEntity(pessoaPersist));
        PessoaResponse response = pessoaMapper.entityToResponse(pessoa);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

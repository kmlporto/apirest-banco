package com.kamila.banco.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaResponse implements Serializable {

    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private LocalDate dataNascimento;
}

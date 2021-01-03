package com.kamila.banco.dtos.persist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaPersist implements Serializable {

    @NotNull(message = "Campo nome não pode ser nulo")
    private String nome;

    @NotNull(message = "Campo email não pode ser nulo")
    private String email;

    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", message = "cpf inválido")
    @NotNull(message = "Campo cpf não pode ser nulo")
    private String cpf;

    @NotNull(message = "Campo data de nascimento não pode ser nulo")
    private LocalDate dataNascimento;

}

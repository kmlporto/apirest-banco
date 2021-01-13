package com.kamila.banco.web.dto.persist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaPersist implements Serializable {

    @NotNull(message = "Campo nome não pode ser nulo")
    private String nome;

    @Email(message = "Email inválido")
    @NotNull(message = "Campo e-mail não pode ser nulo")
    private String email;

    @CPF(message = "CPF inválido")
    @NotNull(message = "Campo CPF não pode ser nulo")
    private String cpf;

    @NotNull(message = "Campo data de nascimento não pode ser nulo")
    private LocalDate dataNascimento;

}

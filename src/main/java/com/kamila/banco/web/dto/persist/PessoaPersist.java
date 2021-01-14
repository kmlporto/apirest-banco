package com.kamila.banco.web.dto.persist;

import com.kamila.banco.enums.TipoPessoa;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
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
    @ApiModelProperty(position = 1, required = true, example = "Kamila Freitas")
    private String nome;

    @Email(message = "Email inválido")
    @NotNull(message = "Campo e-mail não pode ser nulo")
    @ApiModelProperty(position = 2, required = true, example = "example@gmail.com")
    private String email;

    @CPF(message = "CPF inválido")
    @ApiModelProperty(position = 3, required = true, example = "128.799.314-10")
    private String cpf;

    @CNPJ(message = "CNPJ inválido")
    @ApiModelProperty(position = 4, required = true, example = "19.628.332/0001-43")
    private String cnpj;

    @NotNull(message = "Campo data de nascimento não pode ser nulo")
    @ApiModelProperty(position = 5, required = true, example = "2000-01-01")
    private LocalDate dataNascimento;

    @NotNull
    @ApiModelProperty(position = 6, required = true, example = "PF")
    private TipoPessoa tipoPessoa;
}

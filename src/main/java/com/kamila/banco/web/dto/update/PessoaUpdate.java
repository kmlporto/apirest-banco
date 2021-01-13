package com.kamila.banco.web.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaUpdate implements Serializable {

    @Email(message = "Email inválido")
    private String email;

}

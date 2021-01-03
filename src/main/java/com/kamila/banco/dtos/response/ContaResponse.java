package com.kamila.banco.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaResponse implements Serializable {

    private Long id;

    private String agencia;

    private String numero;

    private Long saldo;

    private Long pessoa;
}

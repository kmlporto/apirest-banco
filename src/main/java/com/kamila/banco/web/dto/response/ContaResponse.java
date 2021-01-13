package com.kamila.banco.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaResponse implements Serializable {

    private Long id;

    private String numero;

    private BigDecimal saldo;

    private Long idPessoa;

    private Long idAgencia;
}

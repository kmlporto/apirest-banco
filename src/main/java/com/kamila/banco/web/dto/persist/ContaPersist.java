package com.kamila.banco.web.dto.persist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContaPersist implements Serializable {

    @NotNull
    private Long idPessoa;

    @NotNull
    private Long idAgencia;

    @NotNull
    private String numero;

    @NotNull
    private BigDecimal saldo;
}

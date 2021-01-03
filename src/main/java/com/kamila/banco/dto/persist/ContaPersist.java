package com.kamila.banco.dto.persist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContaPersist implements Serializable {

    @NotNull
    private Long idPessoa;

    @NotNull
    private String agencia;

    @NotNull
    private Long saldo;
}

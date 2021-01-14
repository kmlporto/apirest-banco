package com.kamila.banco.web.dto.persist;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(position = 1, required = true, example = "1")
    private Long idPessoa;

    @NotNull
    @ApiModelProperty(position = 2, required = true, example = "1")
    private Long idAgencia;

    @NotNull
    @ApiModelProperty(position = 3, required = true, example = "123456")
    private String numero;

    @NotNull
    @ApiModelProperty(position = 4, required = true, example = "1000.00")
    private BigDecimal saldo;
}

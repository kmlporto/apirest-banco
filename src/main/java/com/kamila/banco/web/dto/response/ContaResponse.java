package com.kamila.banco.web.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaResponse implements Serializable {

    @ApiModelProperty(position = 1, required = true, example = "1")
    private Long id;

    @ApiModelProperty(position = 2, required = true, example = "1")
    private Long idPessoa;

    @ApiModelProperty(position = 3, required = true, example = "1")
    private Long idAgencia;

    @ApiModelProperty(position = 4, required = true, example = "123456")
    private String numero;

    @ApiModelProperty(position = 5, required = true, example = "1000.00")
    private BigDecimal saldo;

}

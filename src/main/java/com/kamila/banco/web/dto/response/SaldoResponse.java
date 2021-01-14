package com.kamila.banco.web.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class SaldoResponse implements Serializable {

    @ApiModelProperty(position = 1, required = true, example = "1000.00")
    private BigDecimal saldo;
}

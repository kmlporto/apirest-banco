package com.kamila.banco.web.dto.response;

import com.kamila.banco.enums.TipoTransacao;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoResponse implements Serializable {

    @ApiModelProperty(position = 1, required = true, example = "100.00")
    private BigDecimal valor;

    @ApiModelProperty(position = 2, required = true, example = "PF")
    private TipoTransacao tipoTransacao;

    @ApiModelProperty(position = 3, required = true, example = "2021-01-01")
    private LocalDate dataTransacao;
}

package com.kamila.banco.web.dto.persist;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoPersist implements Serializable {

    @NotNull
    @ApiModelProperty(position = 1, required = true, example = "100.00")
    private BigDecimal valor;

}

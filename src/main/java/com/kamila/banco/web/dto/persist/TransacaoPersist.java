package com.kamila.banco.web.dto.persist;

import com.kamila.banco.enums.TipoTransacao;
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
    private BigDecimal valor;

}

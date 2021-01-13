package com.kamila.banco.web.dto.response;

import com.kamila.banco.enums.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoResponse implements Serializable {

    private BigDecimal valor;

    private TipoTransacao tipoTransacao;

    private Long idConta;

    private LocalDateTime dateTime;
}

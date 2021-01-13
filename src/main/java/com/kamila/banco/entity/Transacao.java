package com.kamila.banco.entity;


import com.kamila.banco.enums.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    @ManyToOne
    private Conta conta;

}

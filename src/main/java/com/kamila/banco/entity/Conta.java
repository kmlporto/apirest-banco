package com.kamila.banco.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String agencia;

    private String numero;

    private Long saldo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

}

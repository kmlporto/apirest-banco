package com.kamila.banco.converter;

import com.kamila.banco.dto.persist.ContaPersist;
import com.kamila.banco.dto.persist.PessoaPersist;
import com.kamila.banco.dto.response.ContaResponse;
import com.kamila.banco.dto.response.PessoaResponse;
import com.kamila.banco.entity.Conta;
import com.kamila.banco.entity.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
    Pessoa persitToEntity(PessoaPersist pessoaPersist);

    PessoaResponse entityToResponse(Pessoa pessoa);
}

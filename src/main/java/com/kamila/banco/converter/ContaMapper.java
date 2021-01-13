package com.kamila.banco.converter;

import com.kamila.banco.web.dto.persist.ContaPersist;
import com.kamila.banco.web.dto.response.ContaResponse;
import com.kamila.banco.entity.Conta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContaMapper {
    @Mapping(source = "idPessoa", target = "pessoa.id")
    @Mapping(source = "idAgencia", target = "agencia.id")
    Conta persitToEntity(ContaPersist contaPersist);

    @Mapping(source = "pessoa.id", target = "idPessoa")
    @Mapping(source = "agencia.id", target = "idAgencia")
    ContaResponse entityToResponse(Conta conta);
}

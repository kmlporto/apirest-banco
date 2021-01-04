package com.kamila.banco.converter;

import com.kamila.banco.dto.persist.ContaPersist;
import com.kamila.banco.dto.response.ContaResponse;
import com.kamila.banco.entity.Conta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContaMapper {
    @Mapping(source = "idPessoa", target = "pessoa.id")
    Conta persitToEntity(ContaPersist contaPersist);

    @Mapping(source = "pessoa.id", target = "idPessoa")
    ContaResponse entityToResponse(Conta conta);
}

package com.kamila.banco.converter;

import com.kamila.banco.entity.Transacao;
import com.kamila.banco.web.dto.persist.TransacaoPersist;
import com.kamila.banco.web.dto.response.TransacaoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {

    Transacao persistToEntity(TransacaoPersist persist);

    @Mapping(source = "conta.id", target = "idConta")
    TransacaoResponse entityToResponse(Transacao transacao);
}

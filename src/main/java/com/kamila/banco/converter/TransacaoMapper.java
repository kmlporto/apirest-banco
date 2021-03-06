package com.kamila.banco.converter;

import com.kamila.banco.entity.Transacao;
import com.kamila.banco.web.dto.persist.TransacaoPersist;
import com.kamila.banco.web.dto.response.TransacaoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {

    Transacao persistToEntity(TransacaoPersist persist);

    TransacaoResponse entityToResponse(Transacao transacao);

    List<TransacaoResponse> transacoesToTransacoesResponse(List<Transacao> transacoes);

}

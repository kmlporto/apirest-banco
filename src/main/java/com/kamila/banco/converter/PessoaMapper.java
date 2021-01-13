package com.kamila.banco.converter;

import com.kamila.banco.web.dto.persist.PessoaPersist;
import com.kamila.banco.web.dto.response.PessoaResponse;
import com.kamila.banco.entity.Pessoa;
import com.kamila.banco.web.dto.update.PessoaUpdate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
    Pessoa persitToEntity(PessoaPersist pessoaPersist);

    Pessoa updateToEntity(PessoaUpdate pessoaUpdate);

    PessoaResponse entityToResponse(Pessoa pessoa);
}

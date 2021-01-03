package com.kamila.banco.converter;

import com.kamila.banco.dto.persist.ContaPersist;
import com.kamila.banco.dto.response.ContaResponse;
import com.kamila.banco.entity.Conta;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.Objects;

public class ContaConverterMap {

    private static final Converter<Long, Conta> contaConverter = new AbstractConverter<Long, Conta>(){
        protected Conta convert(Long id) {
            return Objects.isNull(id) ? null : Conta.builder().id(id).build();
        }
    };

    @Component
    public static class PersistToEntity extends PropertyMap<ContaPersist, Conta>{

        @Override
        protected void configure() {
            using(contaConverter).map(source.getIdPessoa(), destination.getPessoa());
        }
    }


    @Component
    public static class EntityToResponse extends PropertyMap<Conta, ContaResponse>{

        @Override
        protected void configure() {
            map().setPessoa(source.getPessoa().getId());
        }
    }
}

package br.com.arquitetura_limpa.infrastructure.adapter.out.mapper;

import br.com.arquitetura_limpa.core.domain.entity.Usuario;
import br.com.arquitetura_limpa.infrastructure.adapter.out.entity.UsuarioJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioJpaMapper {
    Usuario toDomain(UsuarioJpaEntity entity);

    UsuarioJpaEntity toEntity(Usuario domain);
}
package br.com.arquitetura_limpa.application.mapper;

import br.com.arquitetura_limpa.application.dto.UsuarioRequestDTO;
import br.com.arquitetura_limpa.application.dto.UsuarioResponseDTO;
import br.com.arquitetura_limpa.core.domain.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toDomain(UsuarioRequestDTO dto);
    UsuarioResponseDTO toResponseDTO(Usuario usuario);
}
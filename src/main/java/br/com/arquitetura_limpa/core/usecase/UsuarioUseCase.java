package br.com.arquitetura_limpa.core.usecase;

import br.com.arquitetura_limpa.application.dto.UsuarioRequestDTO;
import br.com.arquitetura_limpa.application.dto.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioUseCase {
    UsuarioResponseDTO criar(UsuarioRequestDTO dto);
    UsuarioResponseDTO buscarPorId(Long id);
    List<UsuarioResponseDTO> listarTodos();
    UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto);
    void deletar(Long id);
}
package br.com.arquitetura_limpa.application.port.out;

import br.com.arquitetura_limpa.core.domain.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {
    Usuario salvar(Usuario usuario);
    Optional<Usuario> buscarPorId(Long id);
    List<Usuario> listarTodos();
    void deletarPorId(Long id);
}
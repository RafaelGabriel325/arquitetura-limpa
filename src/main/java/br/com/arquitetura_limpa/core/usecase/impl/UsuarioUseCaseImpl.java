package br.com.arquitetura_limpa.core.usecase.impl;

import br.com.arquitetura_limpa.application.dto.UsuarioRequestDTO;
import br.com.arquitetura_limpa.application.dto.UsuarioResponseDTO;
import br.com.arquitetura_limpa.application.mapper.UsuarioMapper;
import br.com.arquitetura_limpa.application.port.out.UsuarioRepositoryPort;
import br.com.arquitetura_limpa.core.usecase.UsuarioUseCase;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioUseCaseImpl implements UsuarioUseCase {

    private final UsuarioRepositoryPort repository;
    private final UsuarioMapper mapper;

    public UsuarioUseCaseImpl(UsuarioRepositoryPort repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        var usuario = mapper.toDomain(dto);
        return mapper.toResponseDTO(repository.salvar(usuario));
    }

    @Override
    public UsuarioResponseDTO buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @Override
    public List<UsuarioResponseDTO> listarTodos() {
        return repository.listarTodos().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        var usuario = repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        return mapper.toResponseDTO(repository.salvar(usuario));
    }

    @Override
    public void deletar(Long id) {
        repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        repository.deletarPorId(id);
    }
}
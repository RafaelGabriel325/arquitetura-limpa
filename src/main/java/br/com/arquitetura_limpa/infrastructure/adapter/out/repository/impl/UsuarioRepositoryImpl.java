package br.com.arquitetura_limpa.infrastructure.adapter.out.repository.impl;

import br.com.arquitetura_limpa.application.port.out.UsuarioRepositoryPort;
import br.com.arquitetura_limpa.core.domain.entity.Usuario;
import br.com.arquitetura_limpa.infrastructure.adapter.out.entity.UsuarioJpaEntity;
import br.com.arquitetura_limpa.infrastructure.adapter.out.mapper.UsuarioJpaMapper;
import br.com.arquitetura_limpa.infrastructure.adapter.out.repository.SpringUsuarioJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepositoryPort {
    private final SpringUsuarioJpaRepository jpaRepository;
    private final UsuarioJpaMapper mapper;

    public UsuarioRepositoryImpl(SpringUsuarioJpaRepository jpaRepository, UsuarioJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        UsuarioJpaEntity entity = mapper.toEntity(usuario);
        UsuarioJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Usuario> listarTodos() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        jpaRepository.deleteById(id);
    }
}
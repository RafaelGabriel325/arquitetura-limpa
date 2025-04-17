package br.com.arquitetura_limpa.infrastructure.adapter.out.repository;

import br.com.arquitetura_limpa.infrastructure.adapter.out.entity.UsuarioJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringUsuarioJpaRepository extends JpaRepository<UsuarioJpaEntity, Long> {

}
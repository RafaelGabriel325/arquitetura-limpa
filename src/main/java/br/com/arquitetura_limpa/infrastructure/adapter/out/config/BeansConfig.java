package br.com.arquitetura_limpa.infrastructure.adapter.out.config;

import br.com.arquitetura_limpa.application.mapper.UsuarioMapper;
import br.com.arquitetura_limpa.application.port.out.UsuarioRepositoryPort;
import br.com.arquitetura_limpa.core.usecase.UsuarioUseCase;
import br.com.arquitetura_limpa.core.usecase.impl.UsuarioUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public UsuarioUseCase usuarioUseCase(
            UsuarioRepositoryPort usuarioRepositoryPort,
            UsuarioMapper usuarioMapper
    ) {
        return new UsuarioUseCaseImpl(usuarioRepositoryPort, usuarioMapper);
    }
}
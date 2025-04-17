package br.com.arquitetura_limpa.infrastructure.adapter.in.controller;

import br.com.arquitetura_limpa.application.dto.UsuarioRequestDTO;
import br.com.arquitetura_limpa.application.dto.UsuarioResponseDTO;
import br.com.arquitetura_limpa.core.usecase.UsuarioUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDTO criar(@RequestBody UsuarioRequestDTO dto) {
        return usuarioUseCase.criar(dto);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return usuarioUseCase.buscarPorId(id);
    }

    @GetMapping
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioUseCase.listarTodos();
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO atualizar(@PathVariable Long id, @RequestBody UsuarioRequestDTO dto) {
        return usuarioUseCase.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        usuarioUseCase.deletar(id);
    }
}
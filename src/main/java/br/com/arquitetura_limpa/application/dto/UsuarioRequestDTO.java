package br.com.arquitetura_limpa.application.dto;

import lombok.Data;

@Data
public class UsuarioRequestDTO {
    private String nome;
    private String email;
    private String senha;
}
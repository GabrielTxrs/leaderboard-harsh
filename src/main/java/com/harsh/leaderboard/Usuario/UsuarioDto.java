package com.harsh.leaderboard.Usuario;

import lombok.Getter;

import java.time.LocalDate;

@Getter

public class UsuarioDto {

    private int id;
    private String primeiroNome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private int idade;
    private String telefone;
    private String senha;

    @SuppressWarnings("unused")
    public UsuarioDto() {
    }

    public UsuarioDto(int id, String primeiroNome, String sobrenome, LocalDate dataNascimento, int idade, String telefone,
                       String senha) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.telefone = telefone;
        this.senha = senha;
    }
}

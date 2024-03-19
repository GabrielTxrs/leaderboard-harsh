package com.harsh.leaderboard.usuario;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "TB_USUARIO")
public class UsuarioDto {

    @Id
    @Column(name = "ID_USUARIO")
    private Long id;
    @Column(name = "PRIMEIRO_NOME")
    private String primeiroNome;
    private String sobrenome;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;
    private int idade;
    private String telefone;
    private String senha;

    @SuppressWarnings("unused")
    public UsuarioDto() {
    }

    public UsuarioDto(Long id, String primeiroNome, String sobrenome, LocalDate dataNascimento, int idade, String telefone,
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

package com.harsh.leaderboard.usuario;

import com.harsh.leaderboard.usuario.email.Email;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Table(name = "TB_USUARIO")
public class UsuarioDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_USUARIO")
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Column(name = "PRIMEIRO_NOME")
    private String primeiroNome;
    private String sobrenome;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;
    private int idade;
    private String telefone;
    private List<Email> emails;
    private String senha;


    @SuppressWarnings("unused")
    public UsuarioDto() {
    }

    public UsuarioDto(Long idUsuario, String primeiroNome, String sobrenome, LocalDate dataNascimento, int idade,
                      String telefone,
                      String senha) {
        this.idUsuario = idUsuario;
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.telefone = telefone;
        this.senha = senha;
    }

}

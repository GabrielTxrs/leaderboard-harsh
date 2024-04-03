package com.harsh.leaderboard.usuario;

//import com.harsh.leaderboard.usuario.email.Email;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Column(name = "PRIMEIRO_NOME")
    private String primeiroNome;
    @Column(name = "SOBRENOME")
    private String sobrenome;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;
    @Column(name = "IDADE")
    private int idade;
    @Column(name = "TELEFONE")
    private String telefone;
//    private List<Email> emails;
    @Column(name = "SENHA")
    private String senha;


    @SuppressWarnings("unused")
    public Usuario() {
    }

    public Usuario(Long idUsuario, String primeiroNome, String sobrenome, LocalDate dataNascimento, int idade,
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

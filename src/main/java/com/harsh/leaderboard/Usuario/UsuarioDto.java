package com.harsh.leaderboard.Usuario;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table
public class UsuarioDto {
    @Id
    @SequenceGenerator(
            name= "usuario_sequence",
            sequenceName= "usuario_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usuario_sequence"
    )
    private Long id;
    private Integer cpf;
    private String nome;
    private LocalDate dataNascimento;

    public UsuarioDto() {

    }

    public UsuarioDto(Integer cpf, String nome, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public UsuarioDto(Long id, Integer cpf, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}

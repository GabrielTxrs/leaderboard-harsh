package com.harsh.leaderboard.personagem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_PERSONAGEM")
public class Personagem {

    @Id
    @Column(name = "ID_PERSONAGEM")
    private Long idPersonagem;
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Column(name = "IMAGEM")
    private String caminhoImagem;
    @Column(name = "PONTUACAO")
    private long pontuacao;
    @Column(name = "COROAS")
    private int numCoroas;
    @Column(name = "DANO_TOTAL")
    private long danoTotal;
    @Column(name = "VIDA")
    private int vidaMaxima;

    @SuppressWarnings("unused")
    public Personagem() {
    }

    public Personagem(Long idPersonagem, Long idUsuario, String caminhoImagem, long pontuacao, int numCoroas,
                      long danoTotal, int vidaMaxima) {
        this.idPersonagem = idPersonagem;
        this.idUsuario = idUsuario;
        this.caminhoImagem = caminhoImagem;
        this.pontuacao = pontuacao;
        this.numCoroas = numCoroas;
        this.danoTotal = danoTotal;
        this.vidaMaxima = vidaMaxima;
    }


}

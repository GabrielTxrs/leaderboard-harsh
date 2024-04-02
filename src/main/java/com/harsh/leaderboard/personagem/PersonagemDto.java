package com.harsh.leaderboard.personagem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "TB_PERSONAGEM")
public class PersonagemDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PERSONAGEM")
    @Column(name = "ID_PERSONAGEM")
    private Long idPersonagem;
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Column(name = "IMAGEM")
    private String caminhoImagem;
    private long pontuacao;
    @Column(name = "COROAS")
    private int numCoroas;
    @Column(name = "DANO_TOTAL")
    private long danoTotal;
    @Column(name = "VIDA")
    private int vidaMaxima;

    public PersonagemDto() {
    }

    public PersonagemDto(Long idPersonagem, Long idUsuario, String caminhoImagem, long pontuacao, int numCoroas,
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

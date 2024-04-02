package com.harsh.leaderboard.arma;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "TB_ARMA")
public class ArmaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ARMA")
    @Column(name = "ID_ARMA")
    private Long idArma;
    @Column(name = "ID_PERSONAGEM")
    private Long idPersonagem;
    @Column(name = "TIPO_PROJETIL")
    private String tipoProjetil;
    @Column(name = "RANGE_PROJETIL")
    private int rangeProjetil;
    @Column(name = "VEL_PROJETIL")
    private int velocidadeProjetil;
    @Column(name = "IMAGEM")
    private String caminhoImagem;
    @Column(name = "NOME_ARMA")
    private String nomeArma;
    @Column(name = "DANO")
    private int dano;
    @Column(name = "CURA")
    private int cura;

    public ArmaDto(Long idArma, Long idPersonagem, String tipoProjetil, int rangeProjetil, int velocidadeProjetil,
                   String caminhoImagem, String nomeArma, int dano, int cura) {
        this.idArma = idArma;
        this.idPersonagem = idPersonagem;
        this.tipoProjetil = tipoProjetil;
        this.rangeProjetil = rangeProjetil;
        this.velocidadeProjetil = velocidadeProjetil;
        this.caminhoImagem = caminhoImagem;
        this.nomeArma = nomeArma;
        this.dano = dano;
        this.cura = cura;
    }
}

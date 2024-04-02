package com.harsh.leaderboard.usuario.email;

import com.harsh.leaderboard.usuario.UsuarioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Table(name = "TB_EMAIL")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_EMAIL")
    private Long idEmail;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "emails")
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UsuarioDto usuarioDto;
    private String email;

    public Email(Long idEmail, UsuarioDto usuarioDto, String email) {
        this.idEmail = idEmail;
        this.usuarioDto = usuarioDto;
        this.email = email;
    }
}

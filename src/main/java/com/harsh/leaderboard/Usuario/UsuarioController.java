package com.harsh.leaderboard.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/vi/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDto> getUsuario() {
        return usuarioService.getUsuarios();
    }

    @PostMapping
    public void addUsuario(@RequestBody UsuarioDto usuario) {
        usuarioService.addUsuario(usuario);
    }
}

package com.harsh.leaderboard.Usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UsuarioController {

    private final UsuarioService usuarioService;

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioService usuarioService, UsuarioRepository repository) {
        this.usuarioService = usuarioService;
        this.repository = repository;
    }

    @GetMapping("getUsuarioComRepository")
    public ResponseEntity<List<UsuarioDto>> getUsuarioComRepository() {
        return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("getUsuarioBancoLocal")
    public ResponseEntity<List<UsuarioDto>> getUsuarioBancoLocal() {
        return ResponseEntity.ok(usuarioService.getUsuarioBancoLocal());
    }

    @GetMapping("getUsuarioLeaderboard")
    public ResponseEntity<List<UsuarioDto>> getUsuarioLeaderboard() {
        return ResponseEntity.ok(usuarioService.getUsuarioLeaderboard());
    }

    @PostMapping("inserirUsuarioBancoLocal")
    public ResponseEntity<String> inserirUsuarioBancoLocal(@RequestBody UsuarioDto usuario) {
        return ResponseEntity.ok(usuarioService.inserirUsuarioBancoLocal(usuario));
    }

    @PostMapping("inserirUsuarioLeaderboard")
    public ResponseEntity<String> inserirUsuarioLeaderboard(@RequestBody UsuarioDto usuario) {
        return ResponseEntity.ok(usuarioService.inserirUsuarioLeaderboard(usuario));
    }

}

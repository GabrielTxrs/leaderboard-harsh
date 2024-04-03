package com.harsh.leaderboard.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("adicionar")
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.adicionarUsuario(usuario));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Usuario>> getUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.getUsuarioPorId(id));
    }

    @PutMapping("alterar/{id}")
    public ResponseEntity<Usuario> alterarUsuarioPorId(@PathVariable Long id, @RequestBody Usuario dadosUsuario) {
       return ResponseEntity.ok(usuarioService.alterarUsuarioPorId(id, dadosUsuario));
    }
    @DeleteMapping("remover/{id}")
    public ResponseEntity<String> removerUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.removerUsuarioPorId(id));
    }
    @DeleteMapping("remover")
    public ResponseEntity<String> removerUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.removerUsuario(usuario));

    }


    @GetMapping("getUsuarioBancoLocal")
    public ResponseEntity<List<Usuario>> getUsuarioBancoLocal() {
        return ResponseEntity.ok(usuarioService.getUsuarioBancoLocal());
    }

    @GetMapping("getUsuarioLeaderboard")
    public ResponseEntity<List<Usuario>> getUsuarioLeaderboard() {
        return ResponseEntity.ok(usuarioService.getUsuarioLeaderboard());
    }

    @PostMapping("inserirUsuarioBancoLocal")
    public ResponseEntity<String> inserirUsuarioBancoLocal(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.inserirUsuarioBancoLocal(usuario));
    }

    @PostMapping("inserirUsuarioLeaderboard")
    public ResponseEntity<String> inserirUsuarioLeaderboard(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.inserirUsuarioLeaderboard(usuario));
    }

}

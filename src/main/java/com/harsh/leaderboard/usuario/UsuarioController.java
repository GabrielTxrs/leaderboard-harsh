package com.harsh.leaderboard.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("adicionar-usuario")
    public ResponseEntity<UsuarioDto> adicionarUsuario(@RequestBody UsuarioDto usuario) {
        return ResponseEntity.ok(usuarioService.adicionarUsuario(usuario));
    }

    @GetMapping("get-usuarios")
    public ResponseEntity<List<UsuarioDto>> getUsuarios() {
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @GetMapping("get-usuario/{id}")
    public ResponseEntity<Optional<UsuarioDto>> getUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.getUsuarioPorId(id));
    }

    @PutMapping("alterar-usuario/{id}")
    public ResponseEntity<UsuarioDto> alterarUsuarioPorId(@PathVariable Long id, @RequestBody UsuarioDto dadosUsuario) {
       return ResponseEntity.ok(usuarioService.alterarUsuarioPorId(id, dadosUsuario));
    }
    @DeleteMapping("remover-usuario/{id}")
    public ResponseEntity<String> removerUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.removerUsuarioPorId(id));
    }
    @DeleteMapping("remover-usuario")
    public ResponseEntity<String>removerUsuario(@RequestBody UsuarioDto usuario) {
        return ResponseEntity.ok(usuarioService.removerUsuario(usuario));

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

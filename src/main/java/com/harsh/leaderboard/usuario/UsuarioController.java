package com.harsh.leaderboard.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UsuarioController {

    private final UsuarioService usuarioService;

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioService usuarioService, UsuarioRepository repository) {
        this.usuarioService = usuarioService;
        this.repository = repository;
    }

    @PostMapping("adicionar-usuario")
    public ResponseEntity<UsuarioDto> adicionarUsuario(@RequestBody UsuarioDto usuario) {
        return ResponseEntity.ok(repository.save(usuario));
    }

    @GetMapping("get-usuarios")
    public ResponseEntity<List<UsuarioDto>> getUsuarios() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("get-usuario/{id}")
    public ResponseEntity<Optional<UsuarioDto>> getUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @PutMapping("alterar-usuario/{id}")
    public ResponseEntity<UsuarioDto> alterarUsuarioPorId(@PathVariable Long id, @RequestBody UsuarioDto dadosUsuario) {
        UsuarioDto usuarioAtualizado = repository.findById(id).orElseThrow(() -> new RuntimeException("Não há usuário com id: " + id));

        usuarioAtualizado.setIdade(dadosUsuario.getIdade());
        usuarioAtualizado.setSenha(dadosUsuario.getSenha());
        usuarioAtualizado.setPrimeiroNome(dadosUsuario.getPrimeiroNome());
        usuarioAtualizado.setSobrenome(dadosUsuario.getSobrenome());
        usuarioAtualizado.setTelefone(dadosUsuario.getTelefone());
        usuarioAtualizado.setDataNascimento(dadosUsuario.getDataNascimento());

        repository.save(usuarioAtualizado);
        return ResponseEntity.ok(usuarioAtualizado);
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

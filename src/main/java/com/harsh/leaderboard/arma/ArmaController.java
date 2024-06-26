package com.harsh.leaderboard.arma;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("arma")
public class ArmaController {
    private final ArmaService armaService;
    public ArmaController(ArmaService armaService) {
        this.armaService = armaService;
    }

    @PostMapping("adicionar")
    public ResponseEntity<Arma> adicionarArma(@RequestBody Arma arma) {
        return ResponseEntity.ok(armaService.adicionarArma(arma));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Arma>> getArmas() {
        return ResponseEntity.ok(armaService.getArmas());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Arma>> getArmaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(armaService.getArmaPorId(id));
    }

    @PutMapping("alterar/{id}")
    public ResponseEntity<Arma> alterarArmaPorId(@PathVariable Long id, @RequestBody Arma arma) {
        return ResponseEntity.ok(armaService.alterarArmaPorId(id, arma));
    }

    @DeleteMapping("remover/{id}")
    public ResponseEntity<String> removerArmaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(armaService.removerArmaPorId(id));
    }

    @DeleteMapping("remover")
    public ResponseEntity<String> removerArma(@RequestBody Arma arma) {
        return ResponseEntity.ok(armaService.removerArma(arma));
    }
}




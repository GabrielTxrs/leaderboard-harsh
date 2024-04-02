package com.harsh.leaderboard.personagem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("personagem")
public class PersonagemController {
    private final PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @PostMapping("adicionar")
    public ResponseEntity<PersonagemDto> adicionarPersonagem(@RequestBody PersonagemDto personagem) {
        return ResponseEntity.ok(personagemService.adicionarPersonagem(personagem));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<PersonagemDto>> getPersonagems() {
        return ResponseEntity.ok(personagemService.getPersonagems());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<PersonagemDto>> getPersonagemPorId(@PathVariable Long id) {
        return ResponseEntity.ok(personagemService.getPersonagemPorId(id));
    }

    @PutMapping("alterar/{id}")
    public ResponseEntity<PersonagemDto> alterarPersonagemPorId(@PathVariable Long id, @RequestBody PersonagemDto dadosPersonagem) {
        return ResponseEntity.ok(personagemService.alterarPersonagemPorId(id, dadosPersonagem));
    }
    @DeleteMapping("remover/{id}")
    public ResponseEntity<String> removerPersonagemPorId(@PathVariable Long id) {
        return ResponseEntity.ok(personagemService.removerPersonagemPorId(id));
    }
    @DeleteMapping("remover")
    public ResponseEntity<String>removerPersonagem(@RequestBody PersonagemDto personagem) {
        return ResponseEntity.ok(personagemService.removerPersonagem(personagem));

    }
}

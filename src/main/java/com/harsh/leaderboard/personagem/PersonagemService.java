package com.harsh.leaderboard.personagem;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {
    private final PersonagemRepository personagemRepository;
    
    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }
    public Personagem adicionarPersonagem(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public List<Personagem> getPersonagems() {
        return personagemRepository.findAll();
    }

    public Optional<Personagem> getPersonagemPorId(@PathVariable Long id) {
        return personagemRepository.findById(id);
    }

    public Personagem alterarPersonagemPorId(Long id, Personagem dadosPersonagem) {
        Personagem personagemAtualizado = personagemRepository.findById(id).orElseThrow(() -> new RuntimeException("Não há usuário com id: "+id));

        personagemAtualizado.setIdPersonagem(dadosPersonagem.getIdPersonagem());
        personagemAtualizado.setIdUsuario(dadosPersonagem.getIdUsuario());
        personagemAtualizado.setVidaMaxima(dadosPersonagem.getVidaMaxima());
        personagemAtualizado.setCaminhoImagem(dadosPersonagem.getCaminhoImagem());
        personagemAtualizado.setPontuacao(dadosPersonagem.getPontuacao());
        personagemAtualizado.setNumCoroas(dadosPersonagem.getNumCoroas());
        personagemAtualizado.setDanoTotal(dadosPersonagem.getDanoTotal());

        personagemRepository.save(personagemAtualizado);
        return personagemAtualizado;
    }

    public String removerPersonagemPorId(Long id) {
        personagemRepository.deleteById(id);
        return "Personagem removido com sucesso";
    }

    public String removerPersonagem(Personagem personagem) {
        personagemRepository.delete(personagem);
        return "Personagem removido com sucesso";
    }
    
}

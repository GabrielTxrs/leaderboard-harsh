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
    public PersonagemDto adicionarPersonagem(PersonagemDto personagem) {
        return personagemRepository.save(personagem);
    }

    public List<PersonagemDto> getPersonagems() {
        return personagemRepository.findAll();
    }

    public Optional<PersonagemDto> getPersonagemPorId(@PathVariable Long id) {
        return personagemRepository.findById(id);
    }

    public PersonagemDto alterarPersonagemPorId(Long id, PersonagemDto dadosPersonagem) {
        PersonagemDto personagemAtualizado = personagemRepository.findById(id).orElseThrow(() -> new RuntimeException("Não há usuário com id: "+id));

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

    public String removerPersonagem(PersonagemDto personagem) {
        personagemRepository.delete(personagem);
        return "Personagem removido com sucesso";
    }
    
}

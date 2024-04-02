package com.harsh.leaderboard.arma;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmaService {
    private final ArmaRepository armaRepository;

    public ArmaService(ArmaRepository armaRepository) {
        this.armaRepository = armaRepository;
    }

    public ArmaDto adicionarArma(ArmaDto arma) {
        return armaRepository.save(arma);
    }

    public List<ArmaDto> getArmas() {
        return armaRepository.findAll();
    }

    public Optional<ArmaDto> getArmaPorId(Long id) {
        return armaRepository.findById(id);
    }

    public ArmaDto alterarArmaPorId(Long id, ArmaDto arma) {
        ArmaDto existingArma = armaRepository.findById(id).orElseThrow(() -> new RuntimeException("Não há armas com id: "+id));

        existingArma.setIdArma(arma.getIdArma());
        existingArma.setIdPersonagem(arma.getIdPersonagem());
        existingArma.setTipoProjetil(arma.getTipoProjetil());
        existingArma.setRangeProjetil(arma.getRangeProjetil());
        existingArma.setVelocidadeProjetil(arma.getVelocidadeProjetil());
        existingArma.setCaminhoImagem(arma.getCaminhoImagem());
        existingArma.setNomeArma(arma.getNomeArma());
        existingArma.setDano(arma.getDano());
        existingArma.setCura(arma.getCura());

        armaRepository.save(existingArma);
        return existingArma;
    }

    public String removerArmaPorId(Long id) {
        armaRepository.deleteById(id);
        return "Arma de id: "+id+"removida com sucesso";
    }

    public String removerArma(ArmaDto arma) {
        armaRepository.delete(arma);
        return "Arma removida com sucesso";
    }
}

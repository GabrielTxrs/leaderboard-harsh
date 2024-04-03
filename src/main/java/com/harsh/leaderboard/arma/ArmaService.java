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

    public Arma adicionarArma(Arma arma) {
        return armaRepository.save(arma);
    }

    public List<Arma> getArmas() {
        return armaRepository.findAll();
    }

    public Optional<Arma> getArmaPorId(Long id) {
        return armaRepository.findById(id);
    }

    public Arma alterarArmaPorId(Long id, Arma arma) {
        Arma existingArma = armaRepository.findById(id).orElseThrow(() -> new RuntimeException("Não há armas com id: "+id));

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

    public String removerArma(Arma arma) {
        armaRepository.delete(arma);
        return "Arma removida com sucesso";
    }
}
//org.springframework.beans.factory.UnsatisfiedDependencyException:
//Error creating bean with name 'armaController' defined in file

//Unsatisfied dependency expressed through constructor parameter 0:
//Error creating bean with name 'armaService' defined in file

//Unsatisfied dependency expressed through constructor parameter 0:
//Error creating bean with name 'armaRepository' defined in

//ArmaRepository defined in @EnableJpaRepositories declared on EnableJpaRepositoriesConfiguration:
//Not a managed type: class com.harsh.leaderboard.arma.ArmaDto

package domain.controller;

import domain.model.Fruitore;
import domain.model.Proposta;
import integration.ProposteValidePersistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitoreController {
    private Fruitore fruitore;
    private ProposteValidePersistence persistence;

    public FruitoreController(){
        persistence = new ProposteValidePersistence();
    }

    public void archivia(Proposta proposta){
        proposta.registra(fruitore);
        persistence.salva(proposta);
    }

    public void rimuovi(Proposta proposta){
        persistence.rimuovi(proposta);
    }

    public List<String> getProposteArchivio(){
        persistence.getArchivioProposte().forEach(System.out::println);

        return persistence.getArchivioProposte()
                .stream()
                .map(Proposta::getTitolo)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Proposta getProposta(String titolo){
        return persistence.getArchivioProposte()
                .stream()
                .filter(proposta -> proposta.getTitolo().equals(titolo))
                .findFirst()
                .get();
    }

    public Fruitore getFruitore(){
        return fruitore;
    }

    public void salvaProposteValide(){
        persistence.serializza();
    }
}

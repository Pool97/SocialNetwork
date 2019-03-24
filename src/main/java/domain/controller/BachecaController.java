package domain.controller;

import domain.eventi.ArchiviatoreProposta;
import domain.model.Bacheca;
import domain.model.Fruitore;
import domain.model.Proposta;
import integration.BachecaPersistence;
import integration.CronologiaPersistence;

import java.util.ArrayList;
import java.util.List;

public class BachecaController implements ArchiviatoreProposta {
    private Bacheca bacheca;
    private CronologiaPersistence cronologia;
    private BachecaPersistence persistence;


    public BachecaController(){
        cronologia = new CronologiaPersistence();
        persistence = new BachecaPersistence();
        bacheca = persistence.deserializza();
    }

    public void pubblica(Proposta proposta){
        proposta.registra(this);
        bacheca.pubblica(proposta);
    }

    @Override
    public void archivia(Proposta proposta) {
        bacheca.rimuovi(proposta);
        cronologia.salva(proposta);
    }

    public List<String> getProposteAfferentiA(String categoria){
        List<String> proposte = new ArrayList<>();
        for (Proposta proposta : bacheca) {
            if(proposta.getNomeCategoria().equals(categoria))
                proposte.add(proposta.getCategoria().toString());
        }
        return proposte;
    }

    public boolean iscrivi(String nomeProposta, Fruitore fruitore){
        return bacheca.iscrivi(nomeProposta, fruitore);
    }
    public void salvaBacheca(){
        persistence.serializza(bacheca);
    }
}

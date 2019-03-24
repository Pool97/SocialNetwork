package integration;

import domain.model.Proposta;

import java.util.ArrayList;

public class CronologiaPersistence {
    private ArrayList<Proposta> cronologia;

    public void salva(Proposta proposta){
        cronologia.add(proposta);
    }
}

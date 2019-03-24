package domain.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Bacheca implements Iterable<Proposta>{
    private ArrayList<Proposta> proposte;

    public Bacheca(){
        proposte = new ArrayList<>();
    }

    public void pubblica(Proposta proposta){
        System.out.println("Entrato");
        proposte.add(proposta);
    }

    public void aggiorna(){
        proposte.forEach(Proposta::aggiorna);

    }

    public boolean iscrivi(String nomeProposta, Fruitore fruitore){
        for(Proposta proposta : proposte){
            if(proposta.getTitolo().equals(nomeProposta))
                return proposta.registra(fruitore);
        }

        return false;
    }

    public void rimuovi(Proposta proposta){
        proposte.remove(proposta);
    }

    public Proposta getProposta(String titolo){
        return proposte.stream().filter(proposta -> proposta.getTitolo().equals(titolo)).findFirst().get();
    }

    @Override
    public Iterator<Proposta> iterator() {
        return proposte.iterator();
    }
}

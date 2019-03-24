package domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import domain.eventi.ArchiviatoreProposta;

import java.time.LocalDate;
import java.util.ArrayList;

public class Proposta {

    private ArrayList<Fruitore> iscritti;
    @JsonIgnore
    private ArchiviatoreProposta archiviatore;
    private Categoria categoria;
    private Stato statoCorrente;

    public Proposta(){
        iscritti = new ArrayList<>();
    }

    public Proposta(Categoria categoria){
        iscritti = new ArrayList<>();
        this.categoria = categoria;
        statoCorrente = new PropostaValida();
    }

    public void registra(ArchiviatoreProposta archiviatore){
        this.archiviatore = archiviatore;
    }

    public boolean registra(Fruitore fruitore){
        if(!iscritti.contains(fruitore)){
            iscritti.add(fruitore);
            return true;
        }

        return false;
    }

    public void afferisceA(Categoria categoria){
        this.categoria = categoria;
    }

    public void aggiorna(){
        statoCorrente.gestisci(this);

    }

    public void richiediArchiviazione(){
        archiviatore.archivia(this);
    }

    public boolean isIscritto(Fruitore fruitore){
        return iscritti.contains(fruitore);
    }

    public void cambiaStato(Stato nuovoStato){
        this.statoCorrente = nuovoStato;
    }

    public void informaIscritti(String notifica){
        iscritti.forEach(iscritto -> iscritto.notifica(notifica));
    }

    public String getTitolo(){
        return categoria.getTitolo().getValore();
    }

    public int getNumeroAdesioni(){
        return iscritti.size();
    }

    public int getNumeroPartecipanti(){
        return categoria.getNumeroPartecipanti().getValore();
    }

    public LocalDate getTermineIscrizione(){
        return categoria.getTermineIscrizione().getValore();
    }

    public String getNomeCategoria(){
        return categoria.getNome();
    }

    public Categoria getCategoria(){
        return categoria;
    }
}

package domain.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ui.Visitable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PartitaDiCalcio.class, name = "Partita di Calcio")
}
)

public abstract class Categoria implements Visitable {

    private String nome;
    private String descrizione;

    private Campo<String> titolo;
    private Campo<Integer> numeroPartecipanti;
    private Campo<LocalDate> termineIscrizione;
    private Campo<String> luogo;
    private Campo<LocalDate> data;
    private Campo<LocalTime> ora;
    private Campo<LocalDateTime> durata;
    private Campo<Integer> quotaIndividuale;
    private Campo<String> compresoNellaQuota;
    private Campo<LocalDate> dataConclusiva;
    private Campo<LocalTime> oraConclusiva;
    private Campo<String> note;

    public Categoria(){

    }

    public Categoria(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Campo<LocalDate> getTermineIscrizione() {
        return termineIscrizione;
    }

    public Campo<Integer> getNumeroPartecipanti() {
        return numeroPartecipanti;
    }

    public Campo<String> getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo.setValore(titolo);
    }

    public void setNumeroPartecipanti(int numeroPartecipanti) {
        this.numeroPartecipanti.setValore(numeroPartecipanti);
    }

    public void setLuogo(String luogo) {
        this.luogo.setValore(luogo);
    }

    public Campo<String> getLuogo() {
        return luogo;
    }

    public Campo<Integer> getQuotaIndividuale() {
        return quotaIndividuale;
    }

    public void setQuotaIndividuale(int quotaIndividuale) {
        this.quotaIndividuale.setValore(quotaIndividuale);
    }

    @Override
    public String toString() {
        return
                titolo.mostraInformazioni() + "\n" +
                numeroPartecipanti.mostraInformazioni() + "\n" +
                termineIscrizione.mostraInformazioni() + "\n" +
                luogo.mostraInformazioni() + "\n" +
                data.mostraInformazioni() + "\n" +
                ora.mostraInformazioni() + "\n" +
                durata.mostraInformazioni() + "\n"+
                quotaIndividuale.mostraInformazioni() + "\n" +
                compresoNellaQuota.mostraInformazioni() + "\n" +
                dataConclusiva.mostraInformazioni() + "\n" +
                oraConclusiva.mostraInformazioni() + "\n" +
                note.mostraInformazioni() + "\n";
    }
}

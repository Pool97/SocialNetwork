package presentation;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PartitaDiCalcio.class, name = "partitadicalcio")
}
)
public class Categoria {

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

    @Override
    public String toString() {
        return nome + ": " + descrizione + "\n" +
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

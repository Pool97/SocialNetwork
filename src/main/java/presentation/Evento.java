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

public abstract class Evento {
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

    public Evento(){

    }

    @Override
    public String toString() {
        return "\n" + titolo.getNome() + ": " + titolo.getValore() + "\n" +
                numeroPartecipanti.getNome() + ": " + numeroPartecipanti.getValore() + "\n" +
                termineIscrizione.getNome() + ": " + termineIscrizione.getValore() + "\n" +
                luogo.getNome() + ": " + luogo.getValore() + "\n" +
                data.getNome() + ": " + data.getValore() + "\n";
    }
}

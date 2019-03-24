package domain.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PropostaAperta.class, name = "PropostaAperta"),
        @JsonSubTypes.Type(value = PropostaChiusa.class, name = "PropostaChiusa"),
        @JsonSubTypes.Type(value = PropostaFallita.class, name = "PropostaFallita"),
        @JsonSubTypes.Type(value = PropostaValida.class, name = "PropostaValida")
}
)
public interface Stato {
    void gestisci(Proposta context);
}

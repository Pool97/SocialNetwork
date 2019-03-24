package domain.model;

public class PropostaValida implements Stato {

    @Override
    public void gestisci(Proposta context) {
        context.cambiaStato(new PropostaAperta());
    }
}

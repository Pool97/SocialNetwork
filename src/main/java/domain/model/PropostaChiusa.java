package domain.model;

public class PropostaChiusa implements Stato{

    @Override
    public void gestisci(Proposta context) {
        context.richiediArchiviazione();
    }
}

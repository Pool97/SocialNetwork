package domain.model;

import java.time.LocalDate;

public class PropostaAperta implements Stato {

    private final static String PROPOSTA_CHIUSA = "L'evento sarà attuato! La proposta ora diventa chiusa!";
    private final static String PROPOSTA_FALLITA = "L'evento non sarà attuato! La proposta ora diventa fallita!";

    @Override
    public void gestisci(Proposta context) {

       if(scadenza(context)){
            if(context.getNumeroAdesioni() == context.getNumeroPartecipanti()){
                context.informaIscritti(PROPOSTA_CHIUSA);
                context.cambiaStato(new PropostaChiusa());
            }else{
                context.informaIscritti(PROPOSTA_FALLITA);
                context.cambiaStato(new PropostaFallita());
            }
        }
    }

    private boolean scadenza(Proposta context){
        return context.getTermineIscrizione().isEqual(LocalDate.now())
                || LocalDate.now().isAfter(context.getTermineIscrizione());
    }
}

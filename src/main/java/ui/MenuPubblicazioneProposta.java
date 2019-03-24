package ui;

import domain.eventi.ArchivioProvider;
import domain.eventi.PubblicatoreProposta;

public class MenuPubblicazioneProposta extends MyMenu implements OpzioneMenu {

    public MenuPubblicazioneProposta(ArchivioProvider fornitore, PubblicatoreProposta pubblicatore) {
        super("Pubblicazione proposte valide");

        fornitore.getProposteArchivio().forEach(proposta -> aggiungiOpzione(proposta, () -> {
            pubblicatore.pubblica(proposta);
            rimuoviOpzione(proposta);
        }));
    }


    @Override
    public void eseguiAzione() {
        super.esegui();
    }
}

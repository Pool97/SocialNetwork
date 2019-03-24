package ui;

import domain.eventi.BachecaProvider;
import domain.eventi.GestoreProposta;
import service.mylib.InputDati;

public class MenuAdesioneProposta extends MyMenu {
    private final static String MESSAGGIO_ADESIONE = "Vuoi aderire alla proposta?";
    public MenuAdesioneProposta(String categoria, BachecaProvider provider, GestoreProposta gestore) {
        super("Adesione proposte");

        provider.getProposteAfferentiA(categoria).forEach(proposta ->
                aggiungiOpzione(proposta, () -> {
                    if(InputDati.yesOrNo(MESSAGGIO_ADESIONE)) {
                        gestore.iscrivi(proposta);
                        stampa("Adesione effettuata.");
                    }else
                        stampa("Sei già iscritto a tale proposta!");
        }));
    }
}

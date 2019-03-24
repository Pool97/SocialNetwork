package ui;

import domain.eventi.ArchiviatoreProposta;
import domain.eventi.CategorieProvider;

public class MenuCreazioneProposta extends MyMenu implements OpzioneMenu {

    public MenuCreazioneProposta(CategorieProvider fornitore, ArchiviatoreProposta archiviatore) {
        super("Categorie disponibili");

        fornitore.getCategorie().forEach(categoria -> aggiungiOpzione(categoria, () ->
                new CreazioneProposta(archiviatore).creaProposta(fornitore.getCategoria(categoria))));
    }

    @Override
    public void eseguiAzione() {
        super.esegui();
    }
}

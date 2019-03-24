package ui;

import domain.eventi.BachecaProvider;
import domain.eventi.CategorieProvider;
import domain.eventi.GestoreProposta;

public class MenuCategorieBacheca extends MyMenu implements OpzioneMenu {

    public MenuCategorieBacheca(CategorieProvider fornitore, BachecaProvider fornitoreBacheca, GestoreProposta gestore) {
        super("Categorie proposte in bacheca");

        fornitore.getCategorie().forEach(categoria -> aggiungiOpzione(categoria,
                () -> new MenuAdesioneProposta(categoria, fornitoreBacheca, gestore).esegui()));

    }

    @Override
    public void eseguiAzione() {
        super.esegui();
    }
}

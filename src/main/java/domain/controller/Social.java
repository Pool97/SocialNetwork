package domain.controller;

import domain.eventi.*;
import domain.model.Categoria;
import domain.model.Proposta;
import ui.*;

import java.util.List;

public class Social implements ArchiviatoreProposta, PubblicatoreProposta, CategorieProvider, ArchivioProvider, BachecaProvider, GestoreProposta {
    private MyMenu menu;
    private BachecaController bachecaController;
    private FruitoreController fruitoreController;
    private CategorieController categorieController;

    public Social() {
        bachecaController = new BachecaController();
        fruitoreController = new FruitoreController();
        categorieController = new CategorieController();
    }


    @Override
    public void archivia(Proposta proposta) {
        System.out.println(proposta);
        fruitoreController.archivia(proposta);
    }

    @Override
    public void pubblica(String proposta) {
        Proposta pubblicazione = fruitoreController.getProposta(proposta);
        pubblicazione.aggiorna(); //passa a proposta aperta
        bachecaController.pubblica(pubblicazione);
        fruitoreController.rimuovi(pubblicazione);
    }

    public void inizializzatore(){
        menu = new MenuPrincipale();


        menu.aggiungiOpzione("Visualizza bacheca", ()
                -> new MenuCategorieBacheca(this, this, this).eseguiAzione());

        menu.aggiungiOpzione("Crea proposta", () ->
            new MenuCreazioneProposta(this, this).eseguiAzione());

        menu.aggiungiOpzione("Pubblica proposte", () ->
                new MenuPubblicazioneProposta(this, this).eseguiAzione());

        menu.aggiungiOpzione("Gestisci notifiche", new GestioneNotifiche());

        menu.esegui();

        bachecaController.salvaBacheca();
        fruitoreController.salvaProposteValide();

    }

    public static void main(String[] args){
        Social system = new Social();
        system.inizializzatore();
    }

    @Override
    public List<String> getCategorie() {
        return categorieController.getCategorie();
    }

    @Override
    public Categoria getCategoria(String nome) {
        return categorieController.getCategoria(nome);
    }

    @Override
    public List<String> getProposteArchivio() {
        return fruitoreController.getProposteArchivio();
    }

    @Override
    public List<String> getProposteAfferentiA(String categoria) {
        return bachecaController.getProposteAfferentiA(categoria);
    }

    @Override
    public boolean iscrivi(String nomeProposta) {
        return bachecaController.iscrivi(nomeProposta, fruitoreController.getFruitore());
    }

     /*public void serializzaDatiInJson(){
        try {
            CustomObjectMapper.getIstanza().writerWithDefaultPrettyPrinter().writeValue(new File(System.getProperty("user.dir")
                    + "/src/main/resources/" + "bacheca.json"), bacheca);
            CustomObjectMapper.getIstanza().writerWithDefaultPrettyPrinter().writeValue(new File("utenti.json"), fruitore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}

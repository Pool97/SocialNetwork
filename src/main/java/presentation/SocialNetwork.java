package presentation;

import integration.JSONDeserializer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SocialNetwork {
    private ArrayList<Categoria> categorieEventi = new ArrayList<>();
    private InterfacciaTestuale interfacciaTestuale;

    private final static String WORKING_DIR = System.getProperty("user.dir");
    private final static String RESOURCE_DIR = WORKING_DIR + "/src/main/resources/";
    private final static String FILE_CATEGORIE_JSON = RESOURCE_DIR + "categorie_model.json";
    private final static String FILE_EVENTI_JSON = RESOURCE_DIR + "/eventi.json";

    public SocialNetwork() {
        caricaCategorieDaFileJSON();
        caricaEventiDaFileJSON();
        aggiungiVociCategorieAlMenuTestuale();
    }

    public void avvia(){
        int opzioneScelta;

        do{
            interfacciaTestuale.stampaMenu();
            opzioneScelta = interfacciaTestuale.scegliOpzioneDaMenu();

            if(opzioneScelta < categorieEventi.size() && opzioneScelta >= 0) {
                Categoria categoriaScelta = categorieEventi.get(opzioneScelta);
                mostraCaratteristicheCategoria(categoriaScelta);
            }

        }while(opzioneScelta != -1);
    }

    public static void main(String[] args){
        SocialNetwork social = new SocialNetwork();
        social.avvia();
    }

    private void caricaCategorieDaFileJSON(){
        JSONDeserializer<Categoria> deserializer = new JSONDeserializer<>(FILE_CATEGORIE_JSON);
        List<Categoria> categorieDaFileJson = deserializer.deserializzaElenco(Categoria.class);
        categorieEventi = new ArrayList<>(categorieDaFileJson);
    }

    private void caricaEventiDaFileJSON(){
        JSONDeserializer<Evento> deserializer = new JSONDeserializer<>(FILE_EVENTI_JSON);
        List<Evento> eventiDaFileJson = deserializer.deserializzaElenco(Evento.class);
        categorieEventi.get(0).aggiungiEvento(eventiDaFileJson.get(0));
    }

    private void mostraCaratteristicheCategoria(Categoria categoria){
        interfacciaTestuale.stampa("\n");
        interfacciaTestuale.stampa(categoria.getNome() + ": " + categoria.getDescrizione());
        interfacciaTestuale.stampa(categoria.visualizzaEventi());
    }

    private void aggiungiVociCategorieAlMenuTestuale(){
        ArrayList<String> vociCategorie = categorieEventi.stream().map(Categoria::getNome)
                .collect(Collectors.toCollection(ArrayList::new));

        interfacciaTestuale = new InterfacciaTestuale(vociCategorie);
    }
}

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

    public SocialNetwork() {
        caricaCategorieDaFileJSON();
        aggiungiVociCategorieAlMenuTestuale();
    }

    public void avvia(){
        int opzioneScelta;

        do{
            interfacciaTestuale.stampaMenu();
            opzioneScelta = interfacciaTestuale.scegliOpzioneDaMenu();

            if(opzioneScelta < categorieEventi.size() && opzioneScelta >= 0) {
                Categoria categoriaScelta = categorieEventi.get(opzioneScelta);
                mostraCaratteristiche(categoriaScelta);
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
        System.out.println(categorieEventi.size());
    }

    public void mostraCaratteristiche(Categoria categoria){
        interfacciaTestuale.stampa("\n");
        interfacciaTestuale.stampa(categoria.toString());
    }

    private void aggiungiVociCategorieAlMenuTestuale(){
        ArrayList<String> vociCategorie = categorieEventi.stream().map(Categoria::getNome)
                .collect(Collectors.toCollection(ArrayList::new));

        interfacciaTestuale = new InterfacciaTestuale(vociCategorie);
    }
}

package integration;

import domain.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriePersistence {
    private final static String CATEGORIE_FILE = "categorie_model.json";
    private final static String WORKING_DIR = System.getProperty("user.dir");

    public List<Categoria> deserializza(){
        System.out.println(WORKING_DIR);
        JSONDeserializer<Categoria> deserializer = new JSONDeserializer<>(WORKING_DIR + "/src/" + "/main" + "/resources/" + CATEGORIE_FILE);
        return new ArrayList<>(deserializer.deserializzaElenco(Categoria.class));
    }
}

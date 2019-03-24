package integration;

import com.fasterxml.jackson.databind.type.CollectionLikeType;
import domain.model.Proposta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProposteValidePersistence {
    private List<Proposta> proposteValide;
    private final static String WORKING_DIR = System.getProperty("user.dir");

    public ProposteValidePersistence() {
        this.proposteValide = new ArrayList<>();
        proposteValide.addAll(deserializza());
    }

    public void salva(Proposta proposta){
        proposteValide.add(proposta);

    }

    public void rimuovi(Proposta proposta){
        proposteValide.remove(proposta);
    }

    public void serializza(){
        try {
            CustomObjectMapper.getIstanza().writerWithDefaultPrettyPrinter()
                    .writeValue(new File(WORKING_DIR + "/src/main/resources/" + "proposte_valide.json"), proposteValide);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Proposta> deserializza(){
        CollectionLikeType listType = CustomObjectMapper.getIstanza().getTypeFactory()
                .constructCollectionLikeType(ArrayList.class, Proposta.class);

        try {
            return proposteValide  = CustomObjectMapper.getIstanza().readValue(new File(WORKING_DIR + "/src/" + "/main" + "/resources/" + "proposte_valide.json"), listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Proposta> getArchivioProposte(){
        return proposteValide;
    }
}

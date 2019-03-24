package integration;

import domain.model.Bacheca;

import java.io.File;
import java.io.IOException;

public class BachecaPersistence {
    private final static String WORKING_DIR = System.getProperty("user.dir");

    public void serializza(Bacheca bacheca){
        try {
            CustomObjectMapper.getIstanza().writerWithDefaultPrettyPrinter().writeValue(new File(WORKING_DIR + "/src/" + "/main" + "/resources/" + "bacheca.json"), bacheca);
            System.out.println("Serialziza");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bacheca deserializza(){
        try {
            return CustomObjectMapper.getIstanza().readValue(new File(WORKING_DIR + "/src/" + "/main" + "/resources/" + "bacheca.json"), Bacheca.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Bacheca();
    }
}

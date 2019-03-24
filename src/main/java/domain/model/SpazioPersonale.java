package domain.model;

import java.util.ArrayList;

public class SpazioPersonale {
    private ArrayList<String> notifiche;

    public SpazioPersonale() {
        notifiche = new ArrayList<>();
    }

    public void aggiungi(String notifica){
        notifiche.add(notifica);
    }
}

package presentation;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
public class Categoria {

    private String nome;
    private String descrizione;
    private ArrayList<Evento> eventi;

    public Categoria(){

    }

    public Categoria(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
        eventi = new ArrayList<>();
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public ArrayList<Evento> getEventi() {
        return eventi;
    }

    public void aggiungiEvento(Evento evento){
        eventi.add(evento);
    }


    public String visualizzaEventi(){
        if (eventi.size() == 0)
            return "Non ci sono eventi al momento";

        StringBuilder sb = new StringBuilder();

        for(Evento evento : eventi)
            sb.append(evento).append("\n");

        return sb.toString();
    }
}

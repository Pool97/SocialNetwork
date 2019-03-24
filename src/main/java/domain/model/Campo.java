package domain.model;

public class Campo<T>{

    private String nome;
    private String descrizione;
    private boolean obbligatorio;
    private T valore;


    public Campo(){

    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean isObbligatorio() {
        return obbligatorio;
    }

    public void setObbligatorio(boolean obbligatorio) {
        this.obbligatorio = obbligatorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public T getValore() {
        return valore;
    }

    public void setValore(T valore) {
        this.valore = valore;
    }

    public String mostraInformazioni(){
        return nome + ": " + valore;
    }
}

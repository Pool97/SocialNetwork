package presentation;

public class FasciaEta {
    private int etaMinima;
    private int etaMassima;

    public FasciaEta(int etaMinima, int etaMassima) {
        this.etaMinima = etaMinima;
        this.etaMassima = etaMassima;
    }

    public FasciaEta() {
    }

    public int getEtaMinima() {
        return etaMinima;
    }

    public void setEtaMinima(int etaMinima) {
        this.etaMinima = etaMinima;
    }

    public int getEtaMassima() {
        return etaMassima;
    }

    public void setEtaMassima(int etaMassima) {
        this.etaMassima = etaMassima;
    }

    @Override
    public String toString() {
        return etaMinima + "-" + etaMassima + " anni";
    }
}

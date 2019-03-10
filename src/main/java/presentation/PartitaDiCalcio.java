package presentation;

public class PartitaDiCalcio extends Evento {

    private Campo<Genere> genere;
    private Campo<FasciaEta> fasciaEtà;

    public PartitaDiCalcio(){
        super();
    }

    @Override
    public String toString() {
        return super.toString() +
                genere.getNome() + ": "+  genere.getValore() + "\n" +
                fasciaEtà.getNome() + ": " + fasciaEtà.getValore();
    }
}

package presentation;

public class PartitaDiCalcio extends Categoria {

    private Campo<Genere> genere;
    private Campo<FasciaEta> fasciaEtà;

    public PartitaDiCalcio(){
        super();
    }

    @Override
    public String toString() {
        return super.toString() +
                genere.mostraInformazioni() + "\n" + fasciaEtà.mostraInformazioni();
    }
}

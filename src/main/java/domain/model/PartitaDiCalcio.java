package domain.model;

import ui.Visitor;

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

    public Campo<Genere> getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere.setValore(genere);
    }

    public void setFasciaEtà(Campo<FasciaEta> fasciaEtà) {
        this.fasciaEtà = fasciaEtà;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

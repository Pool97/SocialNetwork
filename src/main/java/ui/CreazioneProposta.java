package ui;

import domain.eventi.ArchiviatoreProposta;
import domain.model.Categoria;
import domain.model.PartitaDiCalcio;
import domain.model.Proposta;
import service.mylib.InputDati;

public class CreazioneProposta implements Visitor{
    private ArchiviatoreProposta listener;

    private final static String WORKING_DIR = System.getProperty("user.dir");
    private final static String RESOURCE_DIR = WORKING_DIR + "/src/main/resources/";
    private final static String FILE_CATEGORIE_JSON = RESOURCE_DIR + "categorie_model.json";
    private final static String INSERISCI = "Inserisci ";


    public CreazioneProposta(ArchiviatoreProposta listener) {
        this.listener = listener;
    }

    public void creaProposta(Categoria categoria){

        compilaCampiGenerali(categoria);

        categoria.accept(this);

        listener.archivia(new Proposta(categoria));
    }

    private void compilaCampiGenerali(Categoria categoria){

        categoria.setTitolo(compila(INSERISCI + categoria.getTitolo().getDescrizione(),
                categoria.getTitolo().isObbligatorio()));

        categoria.setNumeroPartecipanti(compila(INSERISCI + categoria.getNumeroPartecipanti().getDescrizione(),
                categoria.getNumeroPartecipanti().isObbligatorio(), 0));

        categoria.setLuogo(compila(INSERISCI + categoria.getLuogo().getDescrizione(),
                categoria.getLuogo().isObbligatorio()));

        categoria.setQuotaIndividuale(compila(INSERISCI + categoria.getQuotaIndividuale().getDescrizione(),
                categoria.getQuotaIndividuale().isObbligatorio(), 0));

    }

    private String compila(String messaggio, boolean obbligatorio){
        return obbligatorio ? InputDati.leggiStringaNonVuota(messaggio) : InputDati.leggiStringa(messaggio);
    }

    private int compila(String messaggio, boolean obbligatorio, int valoreDefault){
        return obbligatorio ? InputDati.leggiIntero(messaggio) : valoreDefault;
    }


    @Override
    public void visit(PartitaDiCalcio categoria) {
        categoria.setGenere(InputDati.leggiEnum("Inserisci" + categoria.getGenere().getDescrizione()));
    }
}

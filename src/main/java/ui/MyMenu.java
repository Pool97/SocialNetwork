package ui;

import service.mylib.InputDati;

import java.util.ArrayList;

public class MyMenu{
  final protected static String CORNICE = "--------------------------------";
  final protected static String VOCE_USCITA = "0\tEsci";
  final private static String RICHIESTA_INSERIMENTO = "Inserisci il numero desiderato oppure esci > ";

  private String titolo;
  private ArrayList<OpzioneMenu> opzioni;
  private ArrayList<String> voci;

  public MyMenu(String titolo){
        this.titolo = titolo;
        voci = new ArrayList<>();
        opzioni = new ArrayList<>();
  }

  public MyMenu(String titolo, ArrayList<String> voci){
        this.titolo = titolo;
        this.voci = voci;
  }

  public void esegui(){
      stampaMenu();
      eseguiOpzione(scegliOpzione());
  }

  public int scegliOpzione() {
	return InputDati.leggiIntero(RICHIESTA_INSERIMENTO, 0, opzioni.size()) - 1;
  }

  public String leggiStringaNonVuota(String messaggio){
      return InputDati.leggiStringaNonVuota(messaggio);
  }

  public String leggiStringa(String messaggio){
      return InputDati.leggiStringa(messaggio);
  }

  public boolean yesOrNo(String messaggio){
      return InputDati.yesOrNo(messaggio);
  }

  public int leggiIntero(String messaggio){
      return InputDati.leggiInteroNonNegativo(messaggio);
  }

  public void stampa(String messaggio){
      System.out.println(messaggio);
  }

  protected void stampaCornice(){
      System.out.println(CORNICE);
      System.out.println(titolo);
      System.out.println(CORNICE);
  }

  protected void stampaVoceUscita(){
      System.out.println();
      System.out.println(VOCE_USCITA);
      System.out.println();
  }

  public void eseguiOpzione(int numero){
      if(numero != -1) {
          opzioni.get(numero).eseguiAzione();
          stampaMenu();
          eseguiOpzione(scegliOpzione());
      }
  }

  public void stampaMenu(){
	stampaCornice();

	for (int i=0; i<voci.size(); i++)
	  System.out.println( (i+1) + "\t" + voci.get(i));

    stampaVoceUscita();
  }

  public void rimuoviOpzione(String voceMenu){
      voci.remove(voceMenu);
  }

  public void aggiungiOpzione(String voceMenu, OpzioneMenu opzione){
      voci.add(voceMenu);
      opzioni.add(opzione);
  }
}


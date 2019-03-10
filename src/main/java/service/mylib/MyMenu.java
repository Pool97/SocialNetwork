package service.mylib;

import java.util.ArrayList;

public class MyMenu {
  final private static String CORNICE = "--------------------------------";
  final private static String VOCE_USCITA = "0\tEsci";
  final private static String RICHIESTA_INSERIMENTO = "Inserisci il numero della categoria desiderata oppure esci > ";

  private String titolo;
  private ArrayList<String> voci;

	
  public MyMenu (String titolo, ArrayList<String> voci){
	this.titolo = titolo;
	this.voci = voci;
  }

  public int scegliOpzione() {
	return InputDati.leggiIntero(RICHIESTA_INSERIMENTO, 0, voci.size()) - 1;
  }
		
  public void stampaMenu(){
	System.out.println(CORNICE);
	System.out.println(titolo);
	System.out.println(CORNICE);

	for (int i=0; i<voci.size(); i++)
	  System.out.println( (i+1) + "\t" + voci.get(i));

    System.out.println();
	System.out.println(VOCE_USCITA);
    System.out.println();
  }
		
}


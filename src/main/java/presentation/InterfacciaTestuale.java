package presentation;

import service.mylib.MyMenu;

import java.util.ArrayList;

public class InterfacciaTestuale {
    private MyMenu menu;

    public InterfacciaTestuale(ArrayList<String> vociMenuPrincipale){
        menu = new MyMenu("Social Network", vociMenuPrincipale);
    }

    public int scegliOpzioneDaMenu(){
        return menu.scegliOpzione();
    }

    public void stampaMenu(){
        menu.stampaMenu();
    }

    public void stampa(String testo){
        System.out.println(testo);
    }
}

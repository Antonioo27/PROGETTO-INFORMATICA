package com.example.provadefinitiva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Gioca {

    private ArrayList<Giocatore> Giocatori;
    private LinkedList<Carta> mazzo;
    private boolean condizione;


    public Gioca(ArrayList<Giocatore> Giocatori){

        this.Giocatori.addAll(Giocatori);
        int numCarte = 40;
        this.mazzo = new LinkedList<Carta>();


        this.condizione = true;
    }

    public LinkedList<Carta> getMazzo(){
        return mazzo;
    }

    public boolean getCondizione(){
        return condizione;
    }

    public void setCondizione(boolean condizione) {
        this.condizione = condizione;
    }

    public void mischia(){
        Collections.shuffle(mazzo);
    }

}

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
        for (int i=0; i < 40 ; i++) {
            this.mazzo.add(new Carta(Seme.DENARI,i+1));
        }

        for (int i=0; i < 10 ; i++) {
            this.mazzo.set(i, new Carta(Seme.DENARI, i+1));
            this.mazzo.set(i+10, new Carta(Seme.SPADE, i+1));
            this.mazzo.set(i+20, new Carta(Seme.COPPE, i+1));
            this.mazzo.set(i+30, new Carta(Seme.BASTONI, i+1));
        }

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

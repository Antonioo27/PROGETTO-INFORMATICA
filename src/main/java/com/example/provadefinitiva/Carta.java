package com.example.provadefinitiva;

public class Carta {
    private Seme s;
    private int valore;

    public Carta(Seme s, int valore){
        this.s = s;
        this.valore = valore;
    }

    public String toString(){
        return " [" + this.valore + " di " +
                this.s + "] ";
    }
}

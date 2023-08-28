package com.example.provadefinitiva;

public class Carta {
    private Seme s;
    private int valore;

    public Carta(Seme s, int valore){
        this.s = s;
        this.valore = valore;
    }
//ciao sono Nicola e sto facendo delle prove con git2
    public String toString(){
        return " [" + this.valore + " di " +
                this.s + "] ";
    }
}

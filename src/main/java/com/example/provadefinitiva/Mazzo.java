package com.example.provadefinitiva;

import java.util.Collections;
import java.util.LinkedList;

public class Mazzo {
        private LinkedList<Carta> mazzo;
        private int numCarte;

        public Mazzo(){
            this.numCarte = 40;
            this.mazzo = new LinkedList<Carta>();

            for (int i=0; i < 10 ; i++) {
                this.mazzo.add(i, new Carta(Seme.DENARI, i+1));
                this.mazzo.add(i+10, new Carta(Seme.DENARI, i+1));
                this.mazzo.add(i+20, new Carta(Seme.DENARI, i+1));
                this.mazzo.add(i+30, new Carta(Seme.DENARI, i+1));
            }
        }

        public void mischia(){
            Collections.shuffle(mazzo);
        }


        public String toString(){
            String s = "";
            for (int i=0; i < numCarte ; i++)
                s += this.mazzo.get(i) + " , ";

            return s;
        }
}

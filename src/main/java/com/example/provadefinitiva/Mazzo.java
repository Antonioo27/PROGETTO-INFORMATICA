package com.example.provadefinitiva;

import java.util.Collections;
import java.util.LinkedList;

public class Mazzo {
        private LinkedList<Carta> mazzo;
        private int numCarte;

        public Mazzo(){
            this.numCarte = 40;
            this.mazzo = new LinkedList<Carta>();
//da rieditare
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

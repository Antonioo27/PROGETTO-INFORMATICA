package com.example.provadefinitiva;

import java.util.Collections;
import java.util.LinkedList;


public class Mazzo {

        private LinkedList<Carta> mazzo = new LinkedList<Carta>();

        public ChiaraFerragni chiaraFerragni;

        public Fedez fedez;

        public CristianoRonaldo cristianoRonaldo;

        public Mazzo(){
                chiaraFerragni=new ChiaraFerragni();
                fedez=new Fedez();
                cristianoRonaldo=new CristianoRonaldo();
                this.mazzo.add(chiaraFerragni);
                this.mazzo.add(cristianoRonaldo);
                this.mazzo.add(fedez);

        }

        public void mischia(){
                Collections.shuffle(this.mazzo);
}

        public LinkedList<Carta> getMazzo(){
                return this.mazzo;
}

        public void setMazzo(LinkedList<Carta> mazzo1){
            this.mazzo=mazzo1;
        }

        public String toString(){
            String s="";
            for(Carta c: this.mazzo)
                s=s+"\t"+c.toString();
            return s;
        }

}

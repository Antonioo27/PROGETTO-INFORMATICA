package com.example.provadefinitiva;
import java.util.ArrayList;
import java.util.LinkedList;

public class Giocatore {
        private String username;
        private int punteggio;
        private ArrayList<Carta> carte=new ArrayList<Carta>(); //carte che giocatore ha in mano


        public Giocatore(String nome,Mazzo mazzo){
            this.username = nome;
            this.punteggio = 0;
            //this.turn = false;
            for(int i=0; i<3; i++ ){
                int indice = (int)(Math.random()*mazzo.getMazzo().size()); //numero casuale da 0 a 2
                this.carte.add(mazzo.getMazzo().get(indice));
                mazzo.getMazzo().remove(indice);
            }
        }

        public Giocatore(String nome){
            this.username = nome;
            this.punteggio= 0;
        }

        public Giocatore(String nome, int punti){
            this.username = nome;
            this.punteggio = punti;
        }

        public int getTotalScore() {
            return punteggio;
        }

        public String getUsername() {
            return username;
        }


        public void setFollower(int totalScore) {
            this.punteggio = totalScore;
        }

        public void setUsername(String username) {
            this.username = username;
        }



     public String toString() {
        String carteinmano="";
        for(Carta c:this.carte)
            carteinmano=carteinmano+" "+c.getNome()+",";
        return username +"," +punteggio+","+carteinmano+"\n";
        }
    }


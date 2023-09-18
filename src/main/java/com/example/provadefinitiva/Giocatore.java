package com.example.provadefinitiva;
import java.util.ArrayList;
import java.util.LinkedList;

public class Giocatore {
        private String username;
        private int follower;
        private boolean turn;
        private ArrayList<Carta> carte; //carte che giocatore ha in mano
       // private Mazzo mazzo=new Mazzo();//carte complessive del mazzzo

        public Giocatore(Mazzo mazzo){
            this.username = null;
            this.follower = 0;
            //this.turn = false;
            for(int i=0; i<3; i++ ){
                int n=(int)(1+Math.random()*mazzo.getMazzo().size());
                this.carte.add(mazzo.getMazzo().get(n));
                mazzo.getMazzo().remove(n);
            }
        }

        public Giocatore(String nome){
            this.username = nome;
            this.follower= 0;
            this.turn = false;
        }

        public Giocatore(String nome, int punti){
            this.username = nome;
            this.follower = punti;
            this.turn = false;
        }

        public int getTotalScore() {
            return follower;
        }

        public String getUsername() {
            return username;
        }

        public boolean isTurn() {
            return turn;
        }



        public void setFollower(int totalScore) {
            this.follower = totalScore;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setTurn(boolean turn) {
            this.turn = turn;
        }



     public String toString() {
String carteinmano="";
for(Carta c:this.carte)
    carteinmano=carteinmano+"\t"+c.toString();
            return "\n[Username] : "+username +","+
                    "\t[Score] : "+follower+","+"\tCarte:"+carteinmano+"\n";
        }
    }


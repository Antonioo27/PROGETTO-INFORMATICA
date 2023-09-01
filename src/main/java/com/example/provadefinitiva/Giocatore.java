package com.example.provadefinitiva;
import java.util.LinkedList;

public class Giocatore {
        private String username;
        private int follower;
        private boolean turn;

        public Giocatore(){
            this.username = null;
            this.follower = 0;
            //this.turn = false;
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
            return "\n[Username] : "+username +
                    "\n[Score] : "+follower;
        }
    }


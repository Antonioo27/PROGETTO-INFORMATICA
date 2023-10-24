package com.example.provadefinitiva;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class Mazzo {

        private LinkedList<Carta> mazzo = new LinkedList<Carta>();

        private ArrayList<String> nomiInfluencer = new ArrayList<String>();

        private ArrayList<Integer> insiemeFollower=new ArrayList<Integer>();

        private ArrayList<Image> immagini = new ArrayList<Image>();


        public Mazzo() {

            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("arianagrande.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("cruise.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("curry.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("deniro.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("djokovic.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("dualipa.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("ferragni.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("ibra.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("james.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("leodicaprio.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("messi.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("musk.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("obama.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("pacino.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("robbie.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("ronaldo.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("smith.jpeg")));
            immagini.add(new Image(getClass().getClassLoader().getResourceAsStream("williams.jpeg")));

            insiemeFollower.addAll(Arrays.asList(85,89,95,84,82,93,90,87,97,88,99,96,83,86,91,98,92,80));
            nomiInfluencer.addAll(Arrays.asList("arianagrande","cruise","curry","deniro","djokovic","dualipa","ferragni","ibra","james","leodicaprio","messi","musk","obama","pacino","robbie","ronaldo","smith","williams"));

              CartaProdDifettoso cartaProdDifettoso= new CartaProdDifettoso("ProdottoDifettoso", new Image(getClass().getClassLoader().getResourceAsStream("perdifollowers.jpeg")),"Un prodotto che hai sponsorizzato è difettoso perdi la meta dei tuoi follower\n");
              CartaVirale cartaVirale=new CartaVirale("ProfiloVirale",new Image(getClass().getClassLoader().getResourceAsStream("profilovirale.jpeg")),"Il tuo profilo è andato virale e guadagni 100 follower\n");
              CartaAnonymous cartaScopriCarte = new CartaAnonymous("ScopriCarte",new Image(getClass().getClassLoader().getResourceAsStream("anonymous.jpeg")),"Hai ricevuto informazioni preziose, vedi le carte deglia altri giocatori\n");

           for(int i=0; i< immagini.size(); i++){
               this.mazzo.add(new CartaInfluencer(nomiInfluencer.get(i),insiemeFollower.get(i), immagini.get(i)));
           }

            this.mazzo.addAll(Arrays.asList(cartaScopriCarte,cartaVirale,cartaProdDifettoso));
            this.mischia();
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
            for(Carta c : this.mazzo)
                s = s + c.getNome()+",";
            return s;
        }

}

package com.example.provadefinitiva;

import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


public class Mazzo {

        private LinkedList<Carta> mazzo = new LinkedList<Carta>();

        private ArrayList<String> nomiInfluencer = new ArrayList<String>();

        private ArrayList<Integer> insiemeFollower=new ArrayList<Integer>();

        private ArrayList<Image> immagini = new ArrayList<Image>();
        private ArrayList<Image> immaginiImprevisti = new ArrayList<Image>();
        private ArrayList<String> ID=new ArrayList<String>();

        public Mazzo() {
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\arianagrande.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\cruise.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\curry.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\deniro.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\djokovic.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\dualipa.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\ferragni.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\ibra.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\james.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\leodicaprio.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\messi.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\musk.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\obama.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\pacino.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\robbie.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\ronaldo.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\smith.jpeg"));
            immagini.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\williams.jpeg"));

            insiemeFollower.addAll(Arrays.asList(85,89,95,84,82,93,90,87,97,88,99,96,83,86,91,98,92,80));
            nomiInfluencer.addAll(Arrays.asList("arianagrande","cruise","curry","deniro","djokovic","dualipa","ferragni","ibra","james","leodicaprio","messi","musk","obama","pacino","robbie","ronaldo","smith","williams"));

            ID.addAll(Arrays.asList("ProfiloVirale","ProdottoDifettoso","InformazioniPreziosa"));


            immaginiImprevisti.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\profilovirale.jpeg"));
            immaginiImprevisti.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\perdifollowers.jpeg"));
            immaginiImprevisti.add(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\vedicarte.jpeg"));

           for(int i=0; i< immagini.size(); i++){
               this.mazzo.add(new CartaInfluencer(nomiInfluencer.get(i),insiemeFollower.get(i), immagini.get(i)));
           }

           for(int j=0; j<ID.size(); j++){
               this.mazzo.add(new CartaImprevisto(ID.get(j), immaginiImprevisti.get(j)));
           }
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

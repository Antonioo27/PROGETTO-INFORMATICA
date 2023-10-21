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
            /*  String configPath = System.getenv("NOME_VARIABILE");
            if (configPath == null) {
                System.err.println("La variabile d'ambiente NOME_VARIABILE non è stata configurata.");
                System.exit(1);
            }

            Properties properties = new Properties();

            try (FileInputStream input = new FileInputStream(configPath)) {
                properties.load(input);
            } catch (IOException ex) {
                System.err.println("Errore durante il caricamento del file di configurazione: " + ex.getMessage());
                System.exit(1);
            }

            // Utilizzo delle proprietà caricate dal file di configurazione
            String valoreProprietà = properties.getProperty("CHIAVE");
            System.out.println("Valore della proprietà: " + valoreProprietà);


             */
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

              CartaProdDifettoso cartaProdDifettoso= new CartaProdDifettoso("ProdottoDifettoso", new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\perdifollowers.jpeg"),"Un prodotto che hai sponsorizzato è difettoso perdi la meta dei tuoi follower\n");
              CartaVirale cartaVirale=new CartaVirale("ProfiloVirale",new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\profilovirale.jpeg"),"Il tuo profilo è andato virale e guadagni 100 follower\n");
              CartaAnonymous cartaScopriCarte = new CartaAnonymous("ScopriCarte",new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\figurine_progetto\\anonymous.jpeg"),"Hai ricevuto informazioni preziose, vedi le carte deglia altri giocatori\n");

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

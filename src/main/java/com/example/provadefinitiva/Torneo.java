package com.example.provadefinitiva;

import org.controlsfx.control.spreadsheet.SpreadsheetCellEditor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Torneo {

    ArrayList<Partita> partite = new ArrayList<Partita>();

    String codiceTorneo;

    public Torneo() {
    }

    public Torneo(String codice) {
        partite = new ArrayList<>(13);
        this.codiceTorneo = codice;
    }

    public void creaQuarti(ArrayList<String> giocatori, String codice) {
        this.codiceTorneo = codice;
        for (int i = 0; i < giocatori.size(); i = i + 3) {
            String codicePartita = String.valueOf((int) (Math.random() * (3000 - 2000 + 1) + 1000));
            ArrayList<String> temp = new ArrayList<String>();
            temp.addAll(Arrays.asList(giocatori.get(i), giocatori.get(i + 1), giocatori.get(i + 2)));
            partite.add(new Partita(temp, codicePartita));
        }

    }

    public void caricaTorneo(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String spartita = scan.nextLine();
            Partita partita = new Partita();
            partita.caricaPartita(new File(spartita + ".csv"));
            this.partite.add(partita);
        }
    }

    public void caricaPartita(int indice) throws FileNotFoundException {
        partite.get(indice).caricaPartita(new File(partite.get(0).getCodice()));
    }

    public Partita getPartita(int indice) {
        return this.partite.get(indice);
    }


    public ArrayList<Partita> getPartiteTorneo() {
        return this.partite;
    }


    public String getCodicePartita(int indice) {
        return this.partite.get(indice).getCodice();
    }


    public void salvaTorneo() throws IOException {
        PrintWriter scrivo = new PrintWriter(this.codiceTorneo + ".csv");
        for (int i = 0; i < this.partite.size(); i++)
            scrivo.println(this.partite.get(i).getCodice());

        scrivo.close();
    }

    public void aggiungiPartitaTorneo(Partita partita) {
        partite.add(partita);
    }


    public HashMap<Integer, Giocatore> checkPartite() throws IOException { //rimuove le partite concluse
        //e si salva l' indice in un vettore
        HashMap<Integer, Giocatore> indiciPartiteFinite = new HashMap<Integer, Giocatore>();
        for (int i = 0; i < partite.size(); i++) {// partite.size() == 0
            if (partite.get(i).getVincitore() != null) {
                indiciPartiteFinite.put(i, partite.get(i).getVincitore());
                System.out.println(indiciPartiteFinite.get(i).getUsername());
                partite.remove(i);
            }
        }



        return indiciPartiteFinite;
    }
}
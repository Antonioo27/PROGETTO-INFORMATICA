package com.example.provadefinitiva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainEngine {

     private static Partita partita;
     private static Torneo torneo;

     public MainEngine(){
         this.partita = new Partita();
         this.torneo = new Torneo();
     }

     //METODI PER IL TORNEO
     public ArrayList<Partita> getPartiteTorneo(){
        return this.torneo.getPartiteTorneo();
    }

     public void aggiungiPartitaTorneo(Partita partita){
         this.torneo.aggiungiPartitaTorneo(partita);
     }

    public void creaQuarti(ArrayList<String> giocatori, String codice) throws IOException {
         this.torneo.creaQuarti(giocatori,codice);
         torneo.salvaTorneo();
    }
    public void creaSemifinali(ArrayList<String> giocatori, String codice) throws IOException {
        this.torneo.creaSemifinali(giocatori,codice);
        torneo.salvaTorneo();
    }
    public void creaFinale(ArrayList<String> giocatori, String codice) throws IOException{
         this.torneo.creaFinale(giocatori,codice);
         this.torneo.salvaTorneo();
    }

    public Partita getPartitaTorneo(int indice){
            return  this.torneo.getPartita(indice);
    }

    public Torneo getTorneo(){
         return this.torneo;
    }

    public void caricaTorneo(File file) throws FileNotFoundException {
         this.torneo.caricaTorneo(file);

    }

    //METODI PER LA PARTITA
    public static void creaPartita(ArrayList<String> nomiGiocatori, String codicepartita) throws FileNotFoundException {
        partita = new Partita(nomiGiocatori,codicepartita);
        partita.salvaPartita();
    }

    public void caricaPartita(File file)  {
        try {
            this.partita.caricaPartita(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Partita getPartita() {
        return partita;
    }

    public void prossimoTurno(){
        this.partita.prossimoTurno();
    }

    public ArrayList<Giocatore> getGiocatori() {
         return this.partita.getGiocatori();
    }

    public int getTurno(){
        return this.partita.getTurno();
    }

    public ArrayList<Carta> getCarteGiocatore(int numeroGiocatore){ //partendo da zero
       return this.partita.getCarteGiocatore(numeroGiocatore);
    }

    public void muoviCarta(int IndiceGiocatore, int IndiceCarta){ //indice partendo da 0
          this.partita.muoviCarta(IndiceGiocatore,IndiceCarta);
    }

    public ArrayList<Carta> getCarteInCampo(){
         return this.getPartita().getCarteInCampo();
    }

    public void CalcolaPunteggio() throws FileNotFoundException {
        this.partita.CalcolaPunteggio();
    }

    public void giocatoriPescano(){
         this.partita.giocatoriPescano();
    }

    public int indiceCartaNullaGiocatore(int indiceGiocatore){
        return this.partita.indiceCartaNullaGiocatore(indiceGiocatore);
    }

    public Mazzo getMazzo(){
        return this.partita.getMazzo();
    }

    public void salvaPartita() throws FileNotFoundException {
         this.partita.salvaPartita();
    }

    public void trovaVincitore(){
             this.partita.trovaVincitore();
    }

    public Giocatore getVincitore(){
             return this.partita.getVincitore();
    }
    }
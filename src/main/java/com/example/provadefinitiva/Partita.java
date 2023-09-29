package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Comparator;
import java.util.Collections;


import java.io.*;
import java.util.*;

public class Partita {

    public Button ButtonSalvaPartita;
    @FXML
    private Label Giocatore1Score;

    @FXML
    private Label Giocatore2Score;

    @FXML
    private Label Giocatore3Score;

    @FXML
    private Button giocaButton;

    @FXML
    private Label labelCodicePartita;

    @FXML
    private Label labelGiocatore1;

    @FXML
    private Label labelGiocatore2;

    @FXML
    private Label labelGiocatore3;

    @FXML
    private ImageView Imm1G1;

    @FXML
    private ImageView Imm1G2;

    @FXML
    private ImageView Imm1G3;

    @FXML
    private ImageView Imm2G1;

    @FXML
    private ImageView Imm2G2;

    @FXML
    private ImageView Imm2G3;

    @FXML
    private ImageView Imm3G1;

    @FXML
    private ImageView Imm3G2;

    @FXML
    private ImageView Imm3G3;

    @FXML
    private Label labelCheckSave;

    @FXML
    private ImageView cartaSelG1;
    @FXML
    private ImageView cartaSelG2;
    @FXML
    private ImageView cartaSelG3;
    @FXML
    private Label labelAllert;

    private ArrayList<Carta> carteSchierate = new ArrayList<Carta>();

    private Mazzo mazzo = new Mazzo();

    private ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();

    private int[] indiciNulli = new int[3];

    private int turno = 1;

    public static CartaInfluencer TrovaMaggiore(ArrayList<Carta> list){

        CartaInfluencer magg=new CartaInfluencer();
    if(list.get(0) instanceof CartaInfluencer)
            magg=(CartaInfluencer) list.get(0); //deniro
    else if(list.get(1) instanceof CartaInfluencer)
        magg=(CartaInfluencer) list.get(1); // prendifollowers
    else if (list.get(2) instanceof CartaInfluencer) {
        magg=(CartaInfluencer) list.get(2);   //robbie
    }

    for(int i=0; i<list.size(); i++) {
        if (list.get(i) instanceof CartaInfluencer && list.get(i).getFollower() > magg.getFollower())
            magg = (CartaInfluencer) list.get(i);
      }
        return magg;
    }

      public void CambiaTurno(){

       if(turno==1){
         if(giocatori.get(0).getCarte().get(0)!=null)
           Imm1G1.setImage(giocatori.get(0).getCarte().get(0).getImage());
         else
           Imm1G1.setImage(null);

        if(giocatori.get(0).getCarte().get(1)!=null)
                   Imm2G1.setImage(giocatori.get(0).getCarte().get(1).getImage());
        else
            Imm2G1.setImage(null);
        if(giocatori.get(0).getCarte().get(2)!=null)
                   Imm3G1.setImage(giocatori.get(0).getCarte().get(2).getImage());
        else
            Imm2G1.setImage(null);

        if(giocatori.get(1).getCarte().get(0)!=null)
               Imm1G2.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
           else Imm1G2.setImage(null);

           if(giocatori.get(1).getCarte().get(1)!=null)
               Imm2G2.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
           else Imm2G2.setImage(null);

           if(giocatori.get(1).getCarte().get(2)!=null)
           Imm3G2.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
           else
            Imm3G2.setImage(null);

           if(giocatori.get(2).getCarte().get(0)!=null)
               Imm1G3.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
            else Imm1G3.setImage(null);

           if(giocatori.get(2).getCarte().get(1)!=null)
               Imm2G3.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
           else Imm2G3.setImage(null);

           if(giocatori.get(2).getCarte().get(2)!=null)
               Imm3G3.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
           else Imm3G3.setImage(null);

        }
          if(turno==2){
            if(giocatori.get(1).getCarte().get(0)!=null)
                          Imm1G2.setImage(giocatori.get(1).getCarte().get(0).getImage());
            else
                Imm1G2.setImage(null);
            if(giocatori.get(1).getCarte().get(1)!=null)
                          Imm2G2.setImage(giocatori.get(1).getCarte().get(1).getImage());
            else
                Imm2G2.setImage(null);

            if(giocatori.get(1).getCarte().get(2)!=null)
                Imm3G2.setImage(giocatori.get(1).getCarte().get(2).getImage());
            else
                Imm3G2.setImage(null);


              if(giocatori.get(0).getCarte().get(0)!=null)
                  Imm1G1.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
              else Imm1G1.setImage(null);

              if(giocatori.get(0).getCarte().get(1)!=null)
                  Imm2G1.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
              else Imm2G1.setImage(null);

              if(giocatori.get(0).getCarte().get(2)!=null)
                  Imm3G1.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
              else Imm3G1.setImage(null);

              if(giocatori.get(2).getCarte().get(0)!=null)
                  Imm1G3.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
              else Imm1G3.setImage(null);

              if(giocatori.get(2).getCarte().get(1)!=null)
                  Imm2G3.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
              else Imm2G3.setImage(null);

              if(giocatori.get(2).getCarte().get(2)!=null)
                  Imm3G3.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
              else Imm3G3.setImage(null);
          }
         else if(turno==3){
            if(giocatori.get(2).getCarte().get(0)!=null)
                Imm1G3.setImage(giocatori.get(2).getCarte().get(0).getImage());
            else
                Imm1G3.setImage(null);
            if(giocatori.get(2).getCarte().get(1)!=null)
                Imm2G3.setImage(giocatori.get(2).getCarte().get(1).getImage());
            else
                Imm2G3.setImage(null);
            if(giocatori.get(2).getCarte().get(2)!=null)
                Imm3G3.setImage(giocatori.get(2).getCarte().get(2).getImage());
            else
                Imm3G3.setImage(null);
              if(giocatori.get(0).getCarte().get(0)!=null)
                  Imm1G1.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
              else Imm1G3.setImage(null);

              if(giocatori.get(0).getCarte().get(1)!=null)
                  Imm2G1.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
              else Imm2G1.setImage(null);

              if(giocatori.get(0).getCarte().get(2)!=null)
                  Imm3G1.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
              else Imm3G1.setImage(null);

              if(giocatori.get(1).getCarte().get(0)!=null)
                  Imm1G2.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
              else Imm1G2.setImage(null);

              if(giocatori.get(1).getCarte().get(1)!=null)
                  Imm2G2.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
              else Imm2G2.setImage(null);

              if(giocatori.get(1).getCarte().get(2)!=null)
                  Imm3G2.setImage(new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\backCard2.jpeg"));
              else Imm3G2.setImage(null);
          }

      }

      public void ridistribuisci(){

        if(this.mazzo.getMazzo().size() >0){
              giocatori.get(0).getCarte().set(indiciNulli[0],this.mazzo.getMazzo().get(0));
              this.mazzo.getMazzo().remove(0);
              giocatori.get(1).getCarte().set(indiciNulli[1],this.mazzo.getMazzo().get(0));
              this.mazzo.getMazzo().remove(0);
              giocatori.get(2).getCarte().set(indiciNulli[2],this.mazzo.getMazzo().get(0));
              this.mazzo.getMazzo().remove(0);
          }
      }


    public Partita() throws Exception {
    }

    @FXML
    void gioca(ActionEvent event) {

                Imm1G1.setImage(giocatori.get(0).getCarte().get(0).getImage());
                Imm2G1.setImage(giocatori.get(0).getCarte().get(1).getImage());
                Imm3G1.setImage(giocatori.get(0).getCarte().get(2).getImage());

                giocaButton.setVisible(false);
    }

        //Metodo per aprire la LeaderBoard
        public void openNewWindow() throws Exception {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LeaderBoard.fxml"));
            Parent root = loader.load();
            LeaderBoard leaderBoard = loader.getController();
            leaderBoard.prendiGiocatori(giocatori);
            stage.setTitle("LeaderBoard");
            stage.setScene(new Scene(root));
            stage.show();
        }


    //Metodo per iniziare una nuova partita
    public void inizia(ArrayList<String> nomi) {
        if (nomi.size() == 3) {
            for (int i = 0; i < nomi.size(); i++) {
                Giocatore g = new Giocatore(nomi.get(i), mazzo);
                giocatori.add(g);
            }
        } else if (nomi.size() == 2) {
            for (int i = 0; i < nomi.size(); i++) {
                Giocatore g = new Giocatore(nomi.get(i), mazzo);
                giocatori.add(g);
            }
            Giocatore bot1 = new Giocatore("Bot1", mazzo);
            giocatori.add(bot1);
        } else {
            for (int i = 0; i < nomi.size(); i++) {
                Giocatore g = new Giocatore(nomi.get(i), mazzo);
                giocatori.add(g);
            }
            Giocatore bot1 = new Giocatore("Bot1", mazzo);
            Giocatore bot2 = new Giocatore("Bot2", mazzo);
            giocatori.add(bot1);
            giocatori.add(bot2);

        }

        labelGiocatore1.setText(giocatori.get(0).getUsername());
        Giocatore1Score.setText("" + giocatori.get(0).getTotalScore());

        labelGiocatore2.setText(giocatori.get(1).getUsername());
        Giocatore2Score.setText("" + giocatori.get(1).getTotalScore());

        labelGiocatore3.setText(giocatori.get(2).getUsername());
        Giocatore3Score.setText("" + giocatori.get(2).getTotalScore());

    }


    public void visualizzaCodicePartita(String text) {
        labelCodicePartita.setText(text);
    }


    public void SalvaPartita() throws IOException {
        PrintWriter scrivo = new PrintWriter(labelCodicePartita.getText() + ".csv");
        scrivo.println(".");
        scrivo.println(mazzo.toString() + "\n");

        for (int i = 0; i < giocatori.size(); i++) {
            scrivo.println(giocatori.get(i).toString());
        }
        scrivo.close();
        labelCheckSave.setVisible(true);
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                labelCheckSave.setVisible(false);
            }
        };
        timer.schedule(timerTask, 2000);

    }

    //Metodo per caricare una partita salvata
    public void carica(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        Mazzo nuovo = new Mazzo();
        scan.nextLine();

        String[] RimanenzeFile = scan.nextLine().split(",");

        LinkedList<Carta> mazzoRimanente = new LinkedList<Carta>();
        System.out.println(RimanenzeFile.length);
            for (int i = 0; i < RimanenzeFile.length; i++) {
                System.out.println("1");
                for (int j = 0; j < nuovo.getMazzo().size(); j++) {
                    Carta c = nuovo.getMazzo().get(j);
                    if (c.getNome().equalsIgnoreCase(RimanenzeFile[i])) {
                        System.out.println("hai inserito "+c.getNome());
                        mazzoRimanente.add(c);
                        nuovo.getMazzo().remove(c);
                        break;
                    }
                }
            }

            this.mazzo.setMazzo(mazzoRimanente);
            scan.nextLine();
            while(scan.hasNextLine()) {
                String s = scan.nextLine();
                if (s != "") {
                    String[] str = s.split(",");
                    ArrayList<Carta> mano = new ArrayList<Carta>();
                    for (int i = 2; i < str.length; i++) {
                        for (int j = 0; j < nuovo.getMazzo().size(); j++) {
                            Carta c = nuovo.getMazzo().get(j);
                            if (c.getNome().equalsIgnoreCase(str[i])) {
                                mano.add(c);
                            }
                        }
                    }
                    this.giocatori.add(new Giocatore(str[0], Integer.parseInt(str[1]), mano));
                }
            }

            labelGiocatore1.setText(giocatori.get(0).getUsername());
            Giocatore1Score.setText("" + giocatori.get(0).getTotalScore());

            labelGiocatore2.setText(giocatori.get(1).getUsername());
            Giocatore2Score.setText("" + giocatori.get(1).getTotalScore());

            labelGiocatore3.setText(giocatori.get(2).getUsername());
            Giocatore3Score.setText("" + giocatori.get(2).getTotalScore());
            System.out.println("Numero giocatori"+giocatori.size());
            System.out.println("Mazzo da cui prendere carte"+nuovo.getMazzo().size());
            System.out.println("Mazzo del game "+this.mazzo.getMazzo().size());

            System.out.println("Carte del primo giocatore "+giocatori.get(0).getCarte().size());
    }

    public String getCodice(){
        return labelCodicePartita.getText();

    }

    /*
    @FXML
    void turnoPartita(int numGiocatore, int indiceCarta) {

        if (turno == numGiocatore) {
            Giocatore g = giocatori.get(numGiocatore - 1);
            cartaSelG1.setImage(g.getCarte().get(indiceCarta).getImage());
            if (giocatori.get(numGiocatore - 1).getCarte().get(indiceCarta) != null) {
                carteSchierate.add(giocatori.get(numGiocatore - 1).getCarte().get(indiceCarta));
                giocatori.get(numGiocatore - 1).getCarte().set(indiceCarta, null);
                Imm1G1.setImage(null);

                if (numGiocatore != 3) {
                    turno += 1;
                } else
                    turno = 1;

            }
        } else
                labelAllert.setText("Giocatore1 non è ancora il tuo turno");

        }
    */


    @FXML
    void muoviCarta1G1(MouseEvent event) {

        if(turno==1) {
            Giocatore g = giocatori.get(0);
            cartaSelG1.setImage(g.getCarte().get(0).getImage());
            if (giocatori.get(0).getCarte().get(0) != null) {
                carteSchierate.add(giocatori.get(0).getCarte().get(0));
                giocatori.get(0).getCarte().set(0, null);
                Imm1G1.setImage(null);
                indiciNulli[0]=0;
                turno = 2;
                CambiaTurno();
            }
        }
        else
            labelAllert.setText("Giocatore1 non è ancora il tuo turno");
    }

    @FXML
    void muoviCarta2G1(MouseEvent event) {
        if(turno==1) {
            Giocatore g = giocatori.get(0);
            cartaSelG1.setImage(g.getCarte().get(1).getImage());
            if(giocatori.get(0).getCarte().get(1)!=null) {
                carteSchierate.add(giocatori.get(0).getCarte().get(1));
                giocatori.get(0).getCarte().set(1,null);
                Imm2G1.setImage(null);
                indiciNulli[0]=1;
                turno = 2;
                CambiaTurno();
            }
        }
        else
            labelAllert.setText("Giocatore1 non è ancora il tuo turno");
    }

    @FXML
    void muoviCarta3G1(MouseEvent event) {
        if(turno==1) {
            Giocatore g = giocatori.get(0);
            cartaSelG1.setImage(g.getCarte().get(2).getImage());
            if(giocatori.get(0).getCarte().get(2)!=null) {
                carteSchierate.add(giocatori.get(0).getCarte().get(2));
                giocatori.get(0).getCarte().set(2,null);
                Imm3G1.setImage(null);
                indiciNulli[0]=2;
                turno = 2;
                CambiaTurno();
            }
        }
        else
            labelAllert.setText("Giocatore1 non è ancora il tuo turno");
    }

    @FXML
    void muoviCarta1G2(MouseEvent event) {

        if(turno==2) {
            Giocatore g = giocatori.get(1);
            cartaSelG2.setImage(g.getCarte().get(0).getImage());
            if(giocatori.get(1).getCarte().get(0)!=null) {
                carteSchierate.add(giocatori.get(1).getCarte().get(0));
                giocatori.get(1).getCarte().set(0,null);
                Imm1G2.setImage(null);
                indiciNulli[1]=0;
                turno = 3;
                CambiaTurno();
            }
        }
        else
            labelAllert.setText("Giocatore2 non è ancora il tuo turno");
    }

    @FXML
    void muoviCarta2G2(MouseEvent event) {
        if(turno==2) {
            Giocatore g = giocatori.get(1);
            cartaSelG2.setImage(g.getCarte().get(1).getImage());
            if(giocatori.get(1).getCarte().get(1)!=null) {
                carteSchierate.add(giocatori.get(1).getCarte().get(1));
                giocatori.get(1).getCarte().set(1,null);
                Imm2G2.setImage(null);
                indiciNulli[1]=1;
                turno = 3;
                CambiaTurno();
            }
        }
        else
            labelAllert.setText("Giocatore2 non è ancora il tuo turno");
    }

    @FXML
    void muoviCarta3G2(MouseEvent event) {

        if(turno==2) {
            Giocatore g = giocatori.get(1);
            cartaSelG2.setImage(g.getCarte().get(2).getImage());
            if(giocatori.get(1).getCarte().get(2)!=null) {
                carteSchierate.add(giocatori.get(1).getCarte().get(2));
                giocatori.get(1).getCarte().set(2, null);
                Imm3G2.setImage(null);
                indiciNulli[1]=2;
                turno = 3;
                CambiaTurno();
            }
        }
        else
            labelAllert.setText("Giocatore2 non è ancora il tuo turno");
    }

    @FXML
    void muoviCarta1G3(MouseEvent event) {
       if(turno==3) {
            Giocatore g = giocatori.get(2);
            cartaSelG3.setImage(g.getCarte().get(0).getImage());
            if(giocatori.get(2).getCarte().get(0)!=null) {
                carteSchierate.add(giocatori.get(2).getCarte().get(0));
                giocatori.get(2).getCarte().set(0,null);
                Imm1G3.setImage(null);
                turno = 1;
                indiciNulli[2]=0;
                this.CalcolaPunteggio();
                this.ridistribuisci();
                CambiaTurno();

            }
        }
        else
            labelAllert.setText("Giocatore3 non è ancora il tuo turno");

    }

    @FXML
    void muoviCarta2G3(MouseEvent event) {

        if(turno==3) {
            Giocatore g = giocatori.get(2);
            cartaSelG3.setImage(g.getCarte().get(1).getImage());
            if(giocatori.get(2).getCarte().get(1)!=null) {
                carteSchierate.add(giocatori.get(2).getCarte().get(1));
                giocatori.get(2).getCarte().set(1,null);
                Imm2G3.setImage(null);
                turno = 1;
                indiciNulli[2]=1;
                this.CalcolaPunteggio();
                this.ridistribuisci();
                CambiaTurno();

            }
        }
        else
            labelAllert.setText("Giocatore3 non è ancora il tuo turno");

    }

    @FXML
    void muoviCarta3G3(MouseEvent event) {
        if(turno==3) {
            Giocatore g = giocatori.get(2);
            cartaSelG3.setImage(g.getCarte().get(2).getImage());
            if(giocatori.get(2).getCarte().get(2)!=null) {
                carteSchierate.add(giocatori.get(2).getCarte().get(2));
                giocatori.get(2).getCarte().set(2,null);
                Imm3G3.setImage(null);
                turno = 1;
                indiciNulli[2]=2;
                this.CalcolaPunteggio();
                this.ridistribuisci();
                CambiaTurno();
            }
        }
        else
            labelAllert.setText("Giocatore3 non è ancora il tuo turno");
    }

     public void CalcolaPunteggio() {

         for (int i = 0; i < carteSchierate.size(); i++) {
             if (carteSchierate.get(i) instanceof CartaImprevisto) {
                 if (i == 0) {
                     if (((CartaImprevisto) carteSchierate.get(i)).getId().equalsIgnoreCase("ProdottoDifettoso")) {
                         giocatori.get(1).setTotalScore(giocatori.get(1).getTotalScore() / 2);
                         Giocatore2Score.setText("" + giocatori.get(1).getTotalScore());
                     }
                     else if (((CartaImprevisto) carteSchierate.get(i)).getId().equalsIgnoreCase("ProfiloVirale")) {
                         giocatori.get(0).setTotalScore(giocatori.get(0).getTotalScore() + 100);
                         Giocatore1Score.setText(""+giocatori.get(0).getTotalScore());
                     } else
                         giocatori.get(0).setTotalScore(giocatori.get(0).getTotalScore() + 100);
                     Giocatore1Score.setText("" +  giocatori.get(0).getTotalScore());
                 } else if (i == 1) {
                     if (((CartaImprevisto) carteSchierate.get(i)).getId().equalsIgnoreCase("ProdottoDifettoso")) {
                         giocatori.get(2).setTotalScore(giocatori.get(2).getTotalScore() / 2);
                         Giocatore3Score.setText("" + giocatori.get(2).getTotalScore());
                     }
                     else if (((CartaImprevisto) carteSchierate.get(i)).getId().equalsIgnoreCase("ProfiloVirale")) {
                         giocatori.get(1).setTotalScore(giocatori.get(1).getTotalScore() + 100);
                         Giocatore2Score.setText("" + giocatori.get(1).getTotalScore());
                     }
                     else
                         giocatori.get(1).setTotalScore(giocatori.get(1).getTotalScore() + 100);
                         Giocatore2Score.setText("" + giocatori.get(1).getTotalScore() );
                 } else
                 {
                     if (((CartaImprevisto) carteSchierate.get(i)).getId().equalsIgnoreCase("ProdottoDifettoso")) {
                         giocatori.get(0).setTotalScore(giocatori.get(0).getTotalScore() / 2);
                         Giocatore1Score.setText("" + giocatori.get(0).getTotalScore());
                     }
                     else if (((CartaImprevisto) carteSchierate.get(i)).getId().equalsIgnoreCase("ProfiloVirale")) {
                         giocatori.get(2).setTotalScore(giocatori.get(2).getTotalScore()+ 100);
                         Giocatore3Score.setText("" + giocatori.get(2).getTotalScore());
                     }
                     else
                         giocatori.get(2).setTotalScore(giocatori.get(2).getTotalScore() + 100);
                     Giocatore3Score.setText("" + giocatori.get(2).getTotalScore());
                 }
             }
         }

         if (carteSchierate.indexOf(TrovaMaggiore(this.carteSchierate)) == 0) {
             this.Giocatore1Score.setText("" + (TrovaMaggiore(this.carteSchierate).getFollower() + Integer.parseInt(Giocatore1Score.getText())));
             this.giocatori.get(0).setTotalScore(Integer.parseInt(Giocatore1Score.getText()));
         }
         else if (carteSchierate.indexOf(TrovaMaggiore(this.carteSchierate)) == 1) {
             this.Giocatore2Score.setText("" + (TrovaMaggiore(this.carteSchierate).getFollower() + Integer.parseInt(Giocatore2Score.getText())));
             this.giocatori.get(1).setTotalScore(Integer.parseInt(Giocatore2Score.getText()));
         } else {
             this.Giocatore3Score.setText("" + (TrovaMaggiore(this.carteSchierate).getFollower() + Integer.parseInt(Giocatore3Score.getText())));
             this.giocatori.get(2).setTotalScore(Integer.parseInt(this.Giocatore3Score.getText()));
         }

         this.carteSchierate = new ArrayList<>();
         Timer timer=new Timer();
          TimerTask timerTask=new TimerTask() {
             @Override
             public void run() {
                 cartaSelG1.setImage(null);
                 cartaSelG2.setImage(null);
                 cartaSelG3.setImage(null);
             }
         };
         timer.schedule(timerTask, 1000);
     }


}
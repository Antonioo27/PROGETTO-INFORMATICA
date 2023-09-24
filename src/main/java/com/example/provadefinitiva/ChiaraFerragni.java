package com.example.provadefinitiva;

import javafx.scene.image.Image;

import java.util.Objects;

public class ChiaraFerragni extends CartaInfluencer {
    public ChiaraFerragni() {
        this.nome = "Chiara Ferragni";
        this.follower = 2900;
        this.immagine =new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\ChiaraFerragni2.PNG");
    }
    public ChiaraFerragni(Image imm){
        this.nome="Chiara Ferragni";
        this.follower=2900;
        this.immagine=imm;
    }
    public String getNome(){
        return "Chiara Ferragni";
    }

    @Override
    public Image getImage() {
        return new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\ChiaraFerragni2.PNG");
    }

    @Override
    public boolean equals(Image imm) {
        if(imm.equals(new Image("ChiaraFerragni.PNG")))
            return true;
        else
            return false;
    }
    public int getFollower(){
        return 2900;
    }

}
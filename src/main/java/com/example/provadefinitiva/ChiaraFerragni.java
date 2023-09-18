package com.example.provadefinitiva;

import javafx.scene.image.Image;

public class ChiaraFerragni extends CartaInfluencer {
    public ChiaraFerragni() {
        this.nome = "Chiara Ferragni";
        this.follower = 2900;
        this.immagine =new Image(getClass().getResourceAsStream( "Chiara Ferragni2.PNG"));
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
        return new Image(getClass().getResourceAsStream("Chiara Ferragni2.PNG"));
    }

    @Override
    public boolean equals(Image imm) {
        if(imm.equals(new Image("Chiara Ferragni.PNG")))
            return true;
        else
            return false;
    }
    public int getFollower(){
        return 2900;
    }

}
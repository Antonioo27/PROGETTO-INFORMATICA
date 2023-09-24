package com.example.provadefinitiva;

import javafx.scene.image.Image;


public class CristianoRonaldo extends CartaInfluencer {
    public CristianoRonaldo() {
        this.nome = "Cristiano Ronaldo";
        this.follower = 2800;
        this.immagine =new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\Cr72.PNG");
    }
    public CristianoRonaldo(Image imm){
        this.nome="CristianoRonaldo";
        this.follower=2800;
        this.immagine=imm;
    }
    public String getNome(){
        return "CristianoRonaldo";
    }

    @Override
    public Image getImage() {
        return new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\Cr72.PNG");
    }

    @Override
    public boolean equals(Image imm) {
        if(imm.equals(new Image("Cr72.PNG")))
            return true;
        else
            return false;
    }
    public int getFollower(){
        return 2800;
    }

}


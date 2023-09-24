package com.example.provadefinitiva;

import javafx.scene.image.Image;

public class Fedez extends CartaInfluencer {
    public Fedez() {
        this.nome = "Fedez";
        this.follower = 1900;
        this.immagine =new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\fedez2.PNG");
    }
    public Fedez(Image imm){
        this.nome="Fedez";
        this.follower=1900;
        this.immagine=imm;
    }
    public String getNome(){
        return "Fedez";
    }

    @Override
    public Image getImage() {
        return new Image("C:\\Users\\HP\\Desktop\\PROGETTO-INFORMATICA\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\fedez2.PNG");
    }

    @Override
    public boolean equals(Image imm) {
        if(imm.equals(new Image("fedez2.PNG")))
            return true;
        else
            return false;
    }
    public int getFollower(){
        return 1900;
    }

}

package com.example.provadefinitiva;

import javafx.scene.image.Image;

public class CartaImprevisto implements Carta {
    String frase;
    Image immagine;

    public CartaImprevisto(){
        this.frase=null;
        this.immagine=null;
    }
    public CartaImprevisto(Image imm){
        this.frase=null;
        this.immagine=imm;
    }

    @Override
    public String getNome() {
        return "Marchetta o dissing e in cui specificheremo l' abilità";
    }

    //anche l' immagine la decideremo insieme
    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public boolean equals(Image imm) {
        if(imm==this.immagine)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return this.frase;
    }
}

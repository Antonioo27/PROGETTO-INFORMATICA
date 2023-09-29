package com.example.provadefinitiva;

import javafx.scene.image.Image;

public class CartaImprevisto implements Carta {
    String frase;
    Image immagine;
    String id;

    public CartaImprevisto(){
        this.frase=null;
        this.immagine=null;
        this.id="";
    }
    public CartaImprevisto(Image imm){
        this.frase=null;
        this.immagine=imm;
        this.id="";
    }
    public CartaImprevisto(String frase, String id){
        this.frase=frase;
        this.immagine=null;
        this.id=id;
    }
public CartaImprevisto(String id, Image imm){
        this.immagine=imm;
        this.id=id;
}
    @Override
    public int getFollower(){
        return 0;
    }

    @Override
    public String getNome() {
        return this.frase;
    }

    //anche l' immagine la decideremo insieme
    @Override
    public Image getImage() {
        return this.immagine;
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

    public String getFrase() {
        return frase;
    }
    public String getId() {
        return this.id;
    }

}

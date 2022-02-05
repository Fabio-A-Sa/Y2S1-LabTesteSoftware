package com.g801.supaplex.Model.Models;

import com.g801.supaplex.Model.Position;

public class Model {

    protected Position pos;
    protected Sprite model;

    public void setPos(Position p){
        pos = p;
    }

    public Position getPos() {
        return pos;
    }

    public Sprite getModel() {
        return model;
    }

    public void setSprite(Character s) {this.model = SpriteFactory.factoryMethod(s);}
}


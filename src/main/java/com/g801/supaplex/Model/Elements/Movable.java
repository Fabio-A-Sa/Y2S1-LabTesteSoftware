package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Controller.Action;
import com.g801.supaplex.Model.Aura.Aura;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Models.Sprite;

public class Movable extends Model {
    protected Aura aura;

    public Movable(){
        super.model = new Sprite();
        super.pos = null;
    }

    public void moveUp(){
        super.pos.addY(-1);
    }

    public void moveDown(){ super.pos.addY(1);}

    public void moveLeft(){
        super.pos.addX(-1);
    }

    public void moveRight(){
        super.pos.addX(1);
    }

    public boolean canMove(Action.Actions action){
        return aura.canMove(action);
    }
}

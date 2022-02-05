package com.g801.supaplex.Model.Aura;

import com.g801.supaplex.Controller.Action;
import com.g801.supaplex.Model.Elements.Movable;
import com.g801.supaplex.Model.Elements.Wall;
import com.g801.supaplex.Model.Models.Model;
import java.util.ArrayList;
import java.util.List;

public class Aura {

    private Movable movable;
    public static List<Model> aura = new ArrayList<>();

    public Aura(Movable m) {
        movable = m;
    }

    public boolean canMove(Action.Actions action){
        Model model = null;
        switch(action) {
            case MOVE_UP -> model = aura.get(0);
            case MOVE_DOWN -> model = aura.get(1);
            case MOVE_LEFT -> model = aura.get(2);
            case MOVE_RIGHT -> model = aura.get(3);
        }
        return !(model instanceof Wall);
    }
}
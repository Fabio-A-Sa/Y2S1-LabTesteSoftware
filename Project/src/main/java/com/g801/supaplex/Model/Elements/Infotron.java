package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

public class Infotron extends Movable {

    public Infotron(Position p){
        super.model = SpriteFactory.factoryMethod('I');
        super.pos = p;
    }
}

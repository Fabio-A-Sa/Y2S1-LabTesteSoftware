package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

public class Rock extends Movable {

    public Rock(Position p) {
        super.model = SpriteFactory.factoryMethod('R');
        super.pos = p;
    }
}

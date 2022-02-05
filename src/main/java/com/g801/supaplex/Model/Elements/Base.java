package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

public class Base extends Model {

    public Base(Position p){
        super.model = SpriteFactory.factoryMethod(' ');
        super.pos = p;
    }
}

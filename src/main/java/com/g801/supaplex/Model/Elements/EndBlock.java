package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

public class EndBlock extends Model {

    public EndBlock(Position p){
        super.model = SpriteFactory.factoryMethod('E');
        super.pos = p;
    }
}
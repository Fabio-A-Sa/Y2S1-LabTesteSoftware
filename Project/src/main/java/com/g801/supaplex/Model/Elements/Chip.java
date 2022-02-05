package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

public class Chip extends Model {

    public Chip(Position p){
        super.model = SpriteFactory.factoryMethod('C');
        super.pos = p;
    }
}
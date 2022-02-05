package com.g801.supaplex.Model.Elements

import com.g801.supaplex.Model.Models.Sprite;
import com.g801.supaplex.Model.Position;
import spock.lang.Specification;

class ChipTest extends Specification {

    private Chip chipBlock;
    private int x = 10;
    private int y = 20;

    def setup() {
        chipBlock = new Chip(new Position(x, y));
    }

    def "Chip Block Position"() {
        expect:
            chipBlock.getPos() == new Position(x, y);
    }

    def "Chip Block Size"() {

        given:
            int height = chipBlock.getModel().getHeight();
            int width = chipBlock.getModel().getWidth();

        expect:
            height == Sprite.height;
            width == Sprite.width;
    }

    def "Chip Block Colors"() {

        given:
            char[][] bitmap = chipBlock.getModel().getBitmap();

        expect:
            bitmap[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'g'
            0 | 2 | 'G'
            1 | 2 | 'G'
            2 | 3 | 'g'
            2 | 6 | 'g'
    }
}
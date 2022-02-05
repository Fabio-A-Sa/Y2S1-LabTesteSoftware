package com.g801.supaplex.Model.Elements

import com.g801.supaplex.Model.Models.Sprite;
import com.g801.supaplex.Model.Position;
import spock.lang.Specification;

class RockTest extends Specification {

    private Rock rockBlock;
    private int x = 10;
    private int y = 20;

    def setup() {
        rockBlock = new Rock(new Position(x, y));
    }

    def "Rock Block Position"() {

        expect:
            rockBlock.getPos() == new Position(x, y);
    }

    def "Rock Block Size"() {

        given:
            int height = rockBlock.getModel().getHeight();
            int width = rockBlock.getModel().getWidth();

        expect:
            height == Sprite.height;
            width == Sprite.width;
    }

    def "Rock Block Colors"() {

        given:
            char[][] bitmap = rockBlock.getModel().getBitmap();

        expect:
            bitmap[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'B'
            1 | 1 | 'C'
            2 | 5 | 'Y'
            1 | 8 | 'C'
            3 | 9 | 'B'
    }
}
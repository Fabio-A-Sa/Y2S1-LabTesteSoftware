package com.g801.supaplex.Model.Elements

import com.g801.supaplex.Model.Models.Sprite;
import com.g801.supaplex.Model.Position;
import spock.lang.Specification;

class EndBlockTest extends Specification {

    private EndBlock endBlock;
    private int x = 10;
    private int y = 20;

    def setup() {
        endBlock = new EndBlock(new Position(x, y));
    }

    def "End Block Position"() {
        expect:
            endBlock.getPos() == new Position(x, y);
    }

    def "End Block Size"() {

        given:
            int height = endBlock.getModel().getHeight();
            int width = endBlock.getModel().getWidth();

        expect:
            height == Sprite.height;
            width == Sprite.width;
    }

    def "End Block Colors"() {

        given:
            char[][] bitmap = endBlock.getModel().getBitmap();

        expect:
            bitmap[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'O'
            0 | 2 | 'W'
            2 | 6 | 'W'
            2 | 7 | 'O'
            4 | 9 | 'O'
    }
}
package com.g801.supaplex.Model.Elements

import com.g801.supaplex.Model.Models.Sprite;
import com.g801.supaplex.Model.Position;
import spock.lang.Specification;

class BaseTest extends Specification {

    private Base baseBlock;
    private int x = 10;
    private int y = 20;

    def setup() {
        baseBlock = new Base(new Position(x, y));
    }

    def "Base Block Position"() {
        expect:
            baseBlock.getPos() == new Position(x, y);
    }

    def "Base Block Size"() {

        given:
            int height = baseBlock.getModel().getHeight();
            int width = baseBlock.getModel().getWidth();

        expect:
            height == Sprite.height;
            width == Sprite.width;
    }

    def "Base Block Colors"() {

        given:
            char[][] bitmap = baseBlock.getModel().getBitmap();
        expect:
            for (int i = 0 ; i < bitmap.length ; i++) {
                for (int j = 0 ; j < bitmap[i].length ; j++) {
                    assert bitmap[i][j] == 'B';
                }
            }
    }
}
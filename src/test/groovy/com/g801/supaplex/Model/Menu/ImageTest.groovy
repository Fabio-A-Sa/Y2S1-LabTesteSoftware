package com.g801.supaplex.Model.Menu

import com.g801.supaplex.Model.Image
import com.g801.supaplex.Model.Position;
import spock.lang.Specification;

class ImageTest extends Specification {

    private char[][] bitmap;
    private Position position;
    private Image image;

    def setup() {
        position = new Position(10, 20);
        bitmap = new char[2][3];
        for (int i = 0 ; i < bitmap.length ; i++) {
            for (int j = 0 ; j < bitmap[i].length ; j++) {
                bitmap[i][j] = 'X';
            }
        }
        image = new Image(position, bitmap);
    }

    def "Initial image Configuration"() {

        expect:
            image.getPosition() == new Position(10, 20);
            image.getBitMap().length == 2;
            image.getBitMap()[0].length == 3;
    }

    def "Image bitmap colors"() {

        expect:
            for (int i = 0 ; i < image.getBitMap().length ; i++) {
                for (int j = 0 ; j < image.getBitMap()[i].length ; j++) {
                    assert bitmap[i][j] == 'X';
                }
            }
    }
}
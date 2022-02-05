package com.g801.supaplex.Model.Models

import spock.lang.Specification;

class SpriteTest extends Specification {

    private Sprite sprite;

    def setup() {
        sprite = new Sprite();
    }

    def "Initial Sprite state"() {

        expect:
            sprite.getWidth() == Sprite.width;
            sprite.getHeight() == Sprite.height;
    }

    def "Sprite Bitmap"() {

        expect:
        sprite.getBitmap().length == Sprite.height;
        sprite.getBitmap()[0].length == Sprite.width;
    }
}
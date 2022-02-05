package com.g801.supaplex.Model;

import spock.lang.Specification;

class SizeTest extends Specification {

    private Size size;

    def setup() {
        this.size = new Size(12, 34);
    }

    def "Get width"() {

        given:
            this.size;
        when:
            int width = size.getWidth();
        then:
            width == 12;
    }

    def "Get height"() {

        given:
            this.size;
        when:
            int height = size.getHeight();
        then:
            height == 34;
    }

    def "Equals"() {

        expect:
            Size s1 = new Size(a, b);
            Size s2 = new Size(c, d);
            Size s3 = new Size(12, 34);
            !s1.equals(s2);
            s3.equals(size);
        where:
            a  | b  | c  | d
            12 | 34 | 23 | 12
            -2 | 2  | 45 | 2
            0  |  0 | 0  | -1
            11 | 34 | 34 | 11
    }

    def "HashCode"() {

        expect:
            Size s1 = new Size(a, b);
            Size s2 = new Size(size.getWidth(), size.getHeight());
            this.size.hashCode() != s1.hashCode();
            this.size.hashCode() == s2.hashCode();
        where:
            a  | b
            34 | 12
            -2 | 2
             0 | 0
            11 | 34
    }
}
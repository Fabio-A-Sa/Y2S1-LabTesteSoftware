package com.g801.supaplex.Model;

import java.util.Objects;

public class Size {

    private final int width;
    private final int height;

    public Size(int width_, int height_) {
        this.width = width_;
        this.height = height_;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return width == size.width && height == size.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}

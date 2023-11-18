package com.example.f23comp1011lh1206780assignment2;

public class Image {
    private int height;
    private String url;
    private int width;

    public Image(String url) {
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }
}

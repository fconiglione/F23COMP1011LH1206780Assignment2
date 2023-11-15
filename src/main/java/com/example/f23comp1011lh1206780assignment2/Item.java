package com.example.f23comp1011lh1206780assignment2;

import java.util.List;

public class Item {
    private Album album;
    private List<Artist> artists;

    public Album getAlbum() {
        return album;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public ExternalUrls getExternalUrls() {
        if (album != null) {
            return album.getExternalUrls();
        }
        return null;
    }
}
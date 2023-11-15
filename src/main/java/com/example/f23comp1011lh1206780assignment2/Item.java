package com.example.f23comp1011lh1206780assignment2;

import java.util.List;

public class Item {
    private Album album;
    private List<Artist> artists;
    private String name;

    public String getName() {
        return name;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getName());

        sb.append(" | ").append(album.getName());

        if (!artists.isEmpty()) {
            sb.append(" | ").append(artists.get(0).getName());
        }

        return sb.toString();
    }
}
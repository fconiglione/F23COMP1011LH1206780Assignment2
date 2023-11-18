package com.example.f23comp1011lh1206780assignment2;

import java.util.List;

public class Item {
    private Album album;
    private List<Artist> artists;
    private String name;

    /**
     * returns song/item name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * returns song/item album
     * @return
     */
    public Album getAlbum() {
        return album;
    }

    /**
     * returns a list of artists from the song/item
     * @return
     */
    public List<Artist> getArtists() {
        return artists;
    }

    /**
     * returns  externalUrls, specifically the spotify song url, from the item/song
     * @return
     */
    public ExternalUrls getExternalUrls() {
            return album.getExternalUrls();
    }

    /**
     * toString method to display items/songs in a listView with a professional format
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getName());

        sb.append(" | ").append(album.getName());

        if (!artists.isEmpty()) { // making sure artists exist before calling for them
            sb.append(" | ").append(artists.get(0).getName());
        }

        return sb.toString();
    }
}
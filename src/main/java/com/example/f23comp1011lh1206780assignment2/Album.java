package com.example.f23comp1011lh1206780assignment2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Album {
    private List<Artist> artists;
    @SerializedName("external_urls")
    private ExternalUrls externalUrls;
    private List<Image> images;
    private String name;
    @SerializedName("release_date")
    private String releaseDate;

    /**
     * returns externalUrls
     * @return
     */
    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    /**
     * returns images list
     * @return
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * returns album name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * returns release date
     * @return
     */
    public String getReleaseDate() {
        return releaseDate;
    }
}

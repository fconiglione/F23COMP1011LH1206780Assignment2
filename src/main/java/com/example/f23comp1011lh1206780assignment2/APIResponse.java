package com.example.f23comp1011lh1206780assignment2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponse {

    private Tracks tracks;

    public Tracks getTracks() {
        return tracks;
    }

    public static class Tracks {
        private List<Item> items;

        public List<Item> getItems() {
            return items;
        }
    }
}
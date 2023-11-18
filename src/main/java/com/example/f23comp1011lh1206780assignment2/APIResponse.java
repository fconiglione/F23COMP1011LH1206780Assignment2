package com.example.f23comp1011lh1206780assignment2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponse {

    private Tracks tracks;

    /**
     * returns tracks
     * @return
     */
    public Tracks getTracks() {
        return tracks;
    }

    public static class Tracks {
        private Integer total;
        private List<Item> items;

        /**
         * returns a list of music songs/items
         * @return
         */
        public List<Item> getItems() {
            return items;
        }

        /**
         * returns the total number of results, since spotify api limits to 50
         * @return
         */
        public Integer getTotal() {
            return total;
        }
    }
}
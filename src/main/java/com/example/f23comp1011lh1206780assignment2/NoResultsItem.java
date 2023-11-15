package com.example.f23comp1011lh1206780assignment2;

public class NoResultsItem extends Item {
    private String message;

    /**
     * The sole reason for this class was to create a blank Item to display a
     * "No results found" message if there are no results for a search query
     * @param message
     */
    public NoResultsItem(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
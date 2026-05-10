package com.smartcollections.model;

import java.io.Serializable;

/**
 * Item - represents a single imported file or resource.
 * Implements Serializable for persistence.
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String category;
    private String tags;
    private int rating;
    private String pathOrUrl;

    public Item(String title, String category, String tags, int rating, String pathOrUrl) {
        this.title = title;
        this.category = category;
        this.tags = tags;
        this.rating = rating;
        this.pathOrUrl = pathOrUrl;
    }

    // Getters
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getTags() { return tags; }
    public int getRating() { return rating; }
    public String getPathOrUrl() { return pathOrUrl; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setTags(String tags) { this.tags = tags; }
    public void setRating(int rating) { this.rating = rating; }
    public void setPathOrUrl(String pathOrUrl) { this.pathOrUrl = pathOrUrl; }

    @Override
    public String toString() {
        return title;
    }
}

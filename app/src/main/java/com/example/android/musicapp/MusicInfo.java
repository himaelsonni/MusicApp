package com.example.android.musicapp;

public class MusicInfo {
    private int imageId;
    private String genre, descr;

    public MusicInfo(int imageId, String genre, String descr) {
        this.imageId = imageId;
        this.genre = genre;
        this.descr = descr;
    }

    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getDescr() {
        return descr;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }
}

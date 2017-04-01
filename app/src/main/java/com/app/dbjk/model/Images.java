package com.app.dbjk.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Images implements Serializable {

    @SerializedName("type")
    private String type;
    @SerializedName("position")
    private int position;
    @SerializedName("url")
    private String url;

    public Images() {
    }

    public Images(String type, Integer position, String url) {
        this.type = type;
        this.position = position;
        this.url = url;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
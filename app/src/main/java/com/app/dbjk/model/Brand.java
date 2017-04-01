package com.app.dbjk.model;

import com.google.gson.annotations.SerializedName;


public class Brand {

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("secondaryName")
    private String secondaryName;


    public Brand(String name, String url, String secondaryName) {
        this.name = name;
        this.url = url;
        this.secondaryName = secondaryName;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecondaryName() {
        return secondaryName;
    }

    public void setSecondaryName(String secondaryName) {
        this.secondaryName = secondaryName;
    }


}

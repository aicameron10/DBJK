package com.app.dbjk.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CurrentVariantProduct {

    @SerializedName("size")
    private String size;
    @SerializedName("color")
    private String color;
    @SerializedName("images")
    private List<Images> images;
    @SerializedName("availability")
    private Availability availability;


    public CurrentVariantProduct(String size, String color, List<Images> images, Availability availability) {
        this.size = size;
        this.images = images;
        this.color = color;
        this.availability = availability;


    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

}

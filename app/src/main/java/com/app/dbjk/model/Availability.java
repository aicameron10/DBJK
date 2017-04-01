package com.app.dbjk.model;

import com.google.gson.annotations.SerializedName;


public class Availability {

    @SerializedName("stock")
    private int stock;
    @SerializedName("canBeOrdered")
    private Boolean canBeOrdered;
    @SerializedName("orderableNow")
    private Boolean orderableNow;
    @SerializedName("availableFuture")
    private Boolean availableFuture;
    @SerializedName("available")
    private Boolean available;


    public Availability(int stock, Boolean canBeOrdered, Boolean orderableNow, Boolean availableFuture, Boolean available) {
        this.stock = stock;
        this.canBeOrdered = canBeOrdered;
        this.orderableNow = orderableNow;
        this.availableFuture = availableFuture;
        this.available = available;


    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Boolean getCanBeOrdered() {
        return canBeOrdered;
    }

    public void setCanBeOrdered(Boolean canBeOrdered) {
        this.canBeOrdered = canBeOrdered;
    }

    public Boolean getOrderableNow() {
        return orderableNow;
    }

    public void setOrderableNow(Boolean orderableNow) {
        this.orderableNow = orderableNow;
    }

    public Boolean getAvailableFuture() {
        return availableFuture;
    }

    public void setAvailableFuture(Boolean availableFuture) {
        this.availableFuture = availableFuture;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }


}

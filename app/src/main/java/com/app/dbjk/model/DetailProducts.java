package com.app.dbjk.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DetailProducts {

    @SerializedName("sellingPrice")
    private SellingPrice sellingPrice;
    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;
    @SerializedName("brand")
    private Brand brand;
    @SerializedName("currentVariantProduct")
    private CurrentVariantProduct currentVariantProduct;


    public DetailProducts(SellingPrice sellingPrice, String url, String name, Brand brand, CurrentVariantProduct currentVariantProduct) {
        this.sellingPrice = sellingPrice;
        this.url = url;
        this.name = name;
        this.brand = brand;
        this.currentVariantProduct = currentVariantProduct;

    }

    public SellingPrice getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(SellingPrice sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public CurrentVariantProduct getCurrentVariantProduct() {
        return currentVariantProduct;
    }

    public void setCurrentVariantProduct(CurrentVariantProduct currentVariantProduct) {
        this.currentVariantProduct = currentVariantProduct;
    }


}


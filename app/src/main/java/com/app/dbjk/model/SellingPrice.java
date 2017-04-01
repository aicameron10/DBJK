package com.app.dbjk.model;

import com.google.gson.annotations.SerializedName;


public class SellingPrice {

    @SerializedName("currencyCode")
    private String currencyCode;
    @SerializedName("value")
    private String value;
    @SerializedName("type")
    private String type;


    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

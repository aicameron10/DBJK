package com.app.dbjk.model;

import com.google.gson.annotations.SerializedName;


public class SearchText {

    @SerializedName("original")
    private String original;
    @SerializedName("corrected")
    private String corrected;
    @SerializedName("searchPass")
    private String searchPass;
    @SerializedName("alternatives")
    private String alternatives;


    public SearchText(String original, String corrected, String searchPass, String alternatives) {
        this.original = original;
        this.corrected = corrected;
        this.searchPass = searchPass;
        this.alternatives = alternatives;


    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getCorrected() {
        return corrected;
    }

    public void setCorrected(String corrected) {
        this.corrected = corrected;
    }

    public String getSearchPass() {
        return searchPass;
    }

    public void setSearchPass(String searchPass) {
        this.searchPass = searchPass;
    }

    public String getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(String alternatives) {
        this.alternatives = alternatives;
    }

}

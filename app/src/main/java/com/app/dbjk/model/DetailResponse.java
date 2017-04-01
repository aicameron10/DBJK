package com.app.dbjk.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DetailResponse {

    @SerializedName("data")
    private Data data;
    @SerializedName("serializeToVersion")
    private String serializeToVersion;


    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getSerializeToVersion() {
        return serializeToVersion;
    }

    public void setSerializeToVersion(String serializeToVersion) {
        this.serializeToVersion = serializeToVersion;
    }


}

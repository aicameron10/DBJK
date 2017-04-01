package com.app.dbjk.rest;

import com.app.dbjk.model.DetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("search")
    Call<DetailResponse> getProducts(@Query("text") String text);


}
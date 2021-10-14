package com.example.food.Network;

import com.example.food.Models.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Client {

    @GET("json/v1/1/random.php")
    Call<Response> getResponse();

    @GET("json/v1/1/search.php?s=Arrabiata")
    Call<Response> getSearchResult();
}

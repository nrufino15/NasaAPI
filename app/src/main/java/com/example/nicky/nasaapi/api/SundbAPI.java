package com.example.nicky.nasaapi.api;

import com.example.nicky.nasaapi.model.SunsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SundbAPI {
    @GET("search?q=Sun")
    Call<SunsList> getSuns();
}

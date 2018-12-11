package com.example.nicky.nasaapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SundbAPI {
    @GET("search?q=Sun")
    Call<SunsList> getSuns();
}

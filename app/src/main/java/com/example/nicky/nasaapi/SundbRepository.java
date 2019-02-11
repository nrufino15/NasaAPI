package com.example.nicky.nasaapi;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.nicky.nasaapi.api.SundbAPI;
import com.example.nicky.nasaapi.api.SundbModule;

import com.example.nicky.nasaapi.model.SunItem;
import com.example.nicky.nasaapi.model.SunResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SundbRepository {
    SundbAPI sundbAPI;

    public SundbRepository(){
        sundbAPI = SundbModule.getAPI();
    }

    public LiveData<List<SunItem>> getSuns(){
        final MutableLiveData<List<SunItem>> lista = new MutableLiveData<>();

        sundbAPI.getSuns().enqueue(new Callback<SunResponse>() {
            @Override
            public void onResponse(Call<SunResponse> call, Response<SunResponse> response) {
                lista.setValue(response.body().collection.items);
            }

            @Override
            public void onFailure(Call<SunResponse> call, Throwable t) {
            }
        });

        return lista;
    }
}

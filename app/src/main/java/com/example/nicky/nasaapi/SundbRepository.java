package com.example.nicky.nasaapi;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SundbRepository {
    SundbAPI sundbAPI;

    public SundbRepository(){
        sundbAPI = SundbModule.getAPI();
    }

    public LiveData<List<Sun>> getSuns(){
        final MutableLiveData<List<Sun>> lista = new MutableLiveData<>();

        sundbAPI.getSuns().enqueue(new Callback<SunsList>() {
            @Override
            public void onResponse(Call<SunsList> call, Response<SunsList> response) {
                lista.setValue(response.body().results);
            }

            @Override
            public void onFailure(Call<SunsList> call, Throwable t) {
            }
        });

        return lista;
    }
}

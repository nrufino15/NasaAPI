package com.example.nicky.nasaapi;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private SundbRepository sundbRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        sundbRepository = new SundbRepository();
    }

    public LiveData<List<Sun>> getMovies(){
        return sundbRepository.getSuns();
    }
}
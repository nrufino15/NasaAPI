package com.example.nicky.nasaapi;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import java.util.List;

public class SunViewModel extends AndroidViewModel {
    private SundbRepository sundbRepository;

    public SunViewModel(@NonNull Application application) {
        super(application);
        sundbRepository = new SundbRepository();
    }

    public LiveData<List<Sun>> getSuns(){
        return sundbRepository.getSuns();
    }
}
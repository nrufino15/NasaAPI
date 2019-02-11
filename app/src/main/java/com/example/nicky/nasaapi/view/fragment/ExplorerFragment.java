package com.example.nicky.nasaapi.view.fragment;


import android.arch.lifecycle.LiveData;

import com.example.nicky.nasaapi.model.Sun;

import java.util.List;

public class ExplorerFragment extends SunListFragment {
    @Override
    LiveData<List<Sun>> getSuns() {
        return sunViewModel.getSuns();
    }
}

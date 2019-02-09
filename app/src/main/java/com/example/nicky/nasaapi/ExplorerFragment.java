package com.example.nicky.nasaapi;


import android.arch.lifecycle.LiveData;
import android.support.v4.app.Fragment;

import java.util.List;

public class ExplorerFragment extends SunListFragment {
    @Override
    LiveData<List<Sun>> getSuns() {
        return sunViewModel.getSuns();
    }
}

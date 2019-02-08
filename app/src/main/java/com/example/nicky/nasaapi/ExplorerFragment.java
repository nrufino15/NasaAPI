package com.example.nicky.nasaapi;


import android.arch.lifecycle.LiveData;
import android.support.v4.app.Fragment;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExplorerFragment extends Fragment, SunListFragment {
    @Override
    LiveData<List<Sun>> getSuns() {
        return sunViewModel.getSuns()
    }
}

package com.example.nicky.nasaapi.view.fragment;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nicky.nasaapi.R;
import com.example.nicky.nasaapi.SunViewModel;
import com.example.nicky.nasaapi.model.Sun;
import com.example.nicky.nasaapi.model.SunItem;
import com.example.nicky.nasaapi.model.SunResponse;
import com.example.nicky.nasaapi.view.SunListAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SunListFragment extends Fragment {


    SunViewModel sunViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sun_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.sunList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final SunListAdapter sunListAdapter = new SunListAdapter();
        recyclerView.setAdapter(sunListAdapter);

        sunViewModel = ViewModelProviders.of(this).get(SunViewModel.class);

        sunViewModel.getSuns().observe(this, new Observer<List<SunItem>>() {
            @Override
            public void onChanged(@Nullable List<SunItem> sunItems) {
                sunListAdapter.sunList = sunItems;
                sunListAdapter.notifyDataSetChanged();
            }
        });


        return view;
    }
}

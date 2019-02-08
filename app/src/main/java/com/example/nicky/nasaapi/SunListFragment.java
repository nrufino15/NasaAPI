package com.example.nicky.nasaapi;


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

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class SunListFragment extends Fragment {


    SunViewModel sunViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sun_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.sunList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final SunListAdapter sunListAdapter = new SunListAdapter();
        recyclerView.setAdapter(sunListAdapter);

        sunViewModel = ViewModelProviders.of(this).get(SunViewModel.class);

        getSuns().observe(this, new Observer<List<Sun>>() {
            @Override
            public void onChanged(@Nullable List<Sun> suns) {
                //sunListAdapter.setList(suns);
                sunListAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    abstract LiveData<List<Sun>> getSuns();

}

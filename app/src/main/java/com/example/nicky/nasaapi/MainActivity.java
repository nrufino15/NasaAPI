package com.example.nicky.nasaapi;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private SunListAdapter mSunListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.sunList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSunListAdapter = new SunListAdapter();
        mRecyclerView.setAdapter(mSunListAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getMovies().observe(this, new Observer<List<Sun>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                mSunListAdapter.movieList = movies;
                mSunListAdapter.notifyDataSetChanged();
            }
        });
    }
}

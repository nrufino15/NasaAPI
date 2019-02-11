package com.example.nicky.nasaapi.view;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.nicky.nasaapi.GlideApp;
import com.example.nicky.nasaapi.R;
import com.example.nicky.nasaapi.model.Sun;

import java.util.ArrayList;
import java.util.List;

public class SunListAdapter extends RecyclerView.Adapter<SunListAdapter.SunListViewHolder>{
    public List<Sun> sunList = new ArrayList<>();

    @NonNull
    @Override
    public SunListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sun, parent, false);
        return new SunListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SunListViewHolder holder, int position) {
        Sun sun = sunList.get(position);

        holder.title.setText(sun.title);
        GlideApp.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w500/" + sun.image_path).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return sunList.size();
    }

    class SunListViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        public SunListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.sunTitle);
            image = itemView.findViewById(R.id.sunImage);
        }
    }
}

package com.example.nicky.nasaapi.view;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.nicky.nasaapi.GlideApp;
import com.example.nicky.nasaapi.R;
import com.example.nicky.nasaapi.model.SunItem;
import com.example.nicky.nasaapi.view.activity.SunActivity;

import java.util.ArrayList;
import java.util.List;

public class SunListAdapter extends RecyclerView.Adapter<SunListAdapter.SunListViewHolder>{
    public List<SunItem> sunList = new ArrayList<>();

    @NonNull
    @Override
    public SunListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sun, parent, false);
        return new SunListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SunListViewHolder holder, int position) {
        SunItem sunItem = sunList.get(position);

        holder.title.setText(sunItem.data.get(0).title);
        GlideApp.with(holder.itemView.getContext()).load(sunItem.links.get(0).href).into(holder.image);

        holder.center.setText(sunItem.data.get(0).center);
        GlideApp.with(holder.itemView.getContext()).load(sunItem.links.get(0).href).into(holder.image);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), SunActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sunList.size();
    }

    class SunListViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView center;
        ImageView image;
        public SunListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.sunTitle);
            center = itemView.findViewById(R.id.sunCenter);
            image = itemView.findViewById(R.id.sunImage);
        }
    }
}

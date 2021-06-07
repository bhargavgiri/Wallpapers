package com.example.wallpaper.Retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wallpaper.R;

import java.util.ArrayList;
import java.util.List;

public class Adeptor extends RecyclerView.Adapter<Adeptor.GithubViewHolder> {
    private Context context;
    public static ArrayList<String> list12;

    public Adeptor(Context context , ArrayList<String> list12) {

        this.context = context;
        this.list12=list12;
    }

    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.imageview,parent,false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder holder, int position) {
        Glide.with(context).load(list12.get(position)).into(holder.imagel);

    }

    @Override
    public int getItemCount() {
        return list12.size();
    }

    public static class GithubViewHolder extends RecyclerView.ViewHolder
    {
            ImageView imagel;
        public GithubViewHolder(@NonNull View itemView) {
            super(itemView);
                imagel=itemView.findViewById(R.id.image12);
        }
    }
}


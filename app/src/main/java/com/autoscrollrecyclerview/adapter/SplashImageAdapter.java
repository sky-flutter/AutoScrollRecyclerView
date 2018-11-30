package com.autoscrollrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.autoscrollrecyclerview.R;
import com.autoscrollrecyclerview.model.ImageName;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SplashImageAdapter extends RecyclerView.Adapter<SplashImageAdapter.ViewHolder> {
    Context context;
    ArrayList<ImageName> imageNames = new ArrayList<>();

    public SplashImageAdapter(ArrayList<ImageName> imageNames, Context context) {
        this.context = context;
        this.imageNames = imageNames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_splash, viewGroup, false);
        return new SplashImageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Glide.with(context).load(imageNames.get(i).getPersonImage()).into(holder.iv_image);
        //holder.iv_image.setImageResource(imageNames.get(i).getPersonImage());
    }

    @Override
    public int getItemCount() {
        return imageNames.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_image;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_image);
        }
    }
}
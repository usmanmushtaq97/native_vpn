package com.tss.lithavpn;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AdapterCountry extends RecyclerView.Adapter<AdapterCountry.MyViewHolder> {
    private final Context mContex;
    private final List< ModelCountry > mList;
    public AdapterCountry(Context mCintex, List<ModelCountry> mList) {
        this.mContex = mCintex;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContex).inflate(R.layout.countrystreaming, parent, false);
        return new MyViewHolder(view);
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        ImageView mImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textView12);
            mImageView = itemView.findViewById(R.id.imageView7);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelCountry rowp = mList.get(position);
        holder.textViewTitle.setText(rowp.getCountry());
        holder.mImageView.setImageResource(rowp.img);
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(mContex, "click", Toast.LENGTH_SHORT).show();
        });

    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
}
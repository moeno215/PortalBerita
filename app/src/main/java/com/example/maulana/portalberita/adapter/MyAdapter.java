package com.example.maulana.portalberita.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.maulana.portalberita.R;
import com.example.maulana.portalberita.model.DataBeritaItem;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<DataBeritaItem> resultsItems;
    Context context;

    public MyAdapter(List<DataBeritaItem> resultsItems, Context context) {
        this.resultsItems = resultsItems;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.listitem, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        myViewHolder.judul.setText(resultsItems.get(position).getJudulBerita());
        myViewHolder.penulis.setText(resultsItems.get(position).getPenulisBerita());

        Glide.with(context)
                .load("http://192.168.95.234/portal_berita/image/" +resultsItems.get(position).getImageBerita())
                .into(myViewHolder.image);

    }

    @Override
    public int getItemCount() {
        return resultsItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView judul, penulis;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.tittle);
            penulis = itemView.findViewById(R.id.author);
            image = itemView.findViewById(R.id.img);

        }
    }
}

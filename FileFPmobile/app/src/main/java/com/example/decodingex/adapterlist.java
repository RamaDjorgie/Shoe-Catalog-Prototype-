package com.example.decodingex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class adapterlist extends RecyclerView.Adapter<adapterlist.ListViewHolder> {

    private ArrayList<movie> listmovie;
    private OnItemClickCallback onItemClickCallback;


    public adapterlist(ArrayList<movie> list) {
        this.listmovie = list;
    }
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listfilm, viewGroup, false);
        return new ListViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        movie movie = listmovie.get(position);
        Glide.with(holder.itemView.getContext())
                .load(movie.getFoto())
                .into(holder.ruangfoto);
        holder.ruangnama.setText(movie.getName());
        holder.ruanggenre.setText(movie.getGenre());
        holder.ruangtahun.setText(movie.getTahun());
        holder.ruangdurasi.setText(movie.getDurasi());
        holder.ruangdetail.setText(movie.getDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listmovie.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listmovie.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView ruangnama,ruanggenre,ruangtahun,ruangdurasi,ruangdetail;
        ImageView ruangfoto;
        ListViewHolder (View itemView) {
            super(itemView);
            ruangnama   = itemView.findViewById(R.id.tvname);
            ruanggenre  = itemView.findViewById(R.id.tvgenre);
            ruangtahun  = itemView.findViewById(R.id.tvtahun);
            ruangdurasi = itemView.findViewById(R.id.tvdurasi);
            ruangdetail = itemView.findViewById(R.id.tvdetail);
            ruangfoto   = itemView.findViewById(R.id.tvfoto);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(movie data);
    }
}

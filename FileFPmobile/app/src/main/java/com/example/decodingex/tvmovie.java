package com.example.decodingex;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class tvmovie extends Fragment {
    private ArrayList<movie> list = new ArrayList<>();


    public tvmovie() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvmovie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list.addAll(getListData());

        RecyclerView recyclerView = view.findViewById(R.id.rv_heroes1);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        final adapterlist homeAdapter = new adapterlist(list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.smoothScrollToPosition(recyclerView.getBottom());
        recyclerView.setAdapter(homeAdapter);

        homeAdapter.setOnItemClickCallback(new adapterlist.OnItemClickCallback() {
            @Override
            public void onItemClicked(movie data) {
                Intent moveIntent1 = new Intent(getContext(), aboutmovie.class);
                moveIntent1.putExtra(aboutmovie.ITEM_EXTRA, data);
                startActivity(moveIntent1);
            }
        });
//

    }

    private ArrayList<movie> getListData(){
        ArrayList<movie> list = new ArrayList<>();
        String[] name = getResources().getStringArray(R.array.tvshows_data_name);
        String[] detail = getResources().getStringArray(R.array.tvshows_data_description);
        String[] tahun = getResources().getStringArray(R.array.tvshows_data_year);
        String[] durasi = getResources().getStringArray(R.array.tvshows_data_duration);
        String[] genre = getResources().getStringArray(R.array.tvshows_data_genres);
        TypedArray foto= getResources().obtainTypedArray(R.array.tvshows_data_photo);

        for (int position = 0; position < name.length; position++) {
            movie movie = new movie();
            movie.setName(name[position]);
            movie.setDetail(detail[position]);
            movie.setTahun(tahun[position]);
            movie.setGenre(genre[position]);
            movie.setFoto(foto.getResourceId(position,-1));
            movie.setDurasi(durasi[position]);
            list.add(movie);
        }
        return list;
    }


}

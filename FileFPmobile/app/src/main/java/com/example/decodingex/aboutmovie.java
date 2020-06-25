package com.example.decodingex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class aboutmovie extends AppCompatActivity {

    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutmovie);

        ImageView rfoto = findViewById(R.id.img_item_photo);
        TextView rnama = findViewById(R.id.textView);
        TextView rgenre= findViewById(R.id.textView2);
        TextView rtahun = findViewById(R.id.textView4);
        TextView rdetail = findViewById(R.id.textView7);
        TextView rdurasi = findViewById(R.id.textView3);

        movie movie = getIntent().getParcelableExtra(ITEM_EXTRA);

        if (movie != null) {
            Glide.with(this)
                    .load(movie.getFoto())
                    .into(rfoto);
            rnama.setText(movie.getName());
            rgenre.setText(movie.getGenre());
            rtahun.setText(movie.getTahun());
            rdetail.setText(movie.getDetail());
            rdurasi.setText(movie.getDurasi());
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}

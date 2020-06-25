package com.example.decodingex;

import android.os.Parcel;
import android.os.Parcelable;

public class movie implements Parcelable{

    private String name;
    private String genre;
    private String tahun;
    private String durasi;
    private String detail;
    private int foto;


    public movie(){

    }

    public static final Parcelable.Creator<movie> CREATOR = new Parcelable.Creator<movie>() {
        @Override
        public movie createFromParcel(Parcel in) {
            return new movie(in);
        }

        @Override
        public movie[] newArray(int size) {
            return new movie[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {

            return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(genre);
        parcel.writeString(tahun);
        parcel.writeString(durasi);
        parcel.writeString(detail);
        parcel.writeInt(foto);

    }

    protected movie(Parcel in){
        name  = in.readString();
        genre = in.readString();
        tahun = in.readString();
        durasi= in.readString();
        detail= in.readString();
        foto  = in.readInt();

    }
}
package com.example.moviekatalog2;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable{
    private int Photo;

    public Movie(Parcel in) {
        Photo = in.readInt();
        name = in.readString();
        genre = in.readString();
        Rating = in.readString();
        description = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie() {

    }

    public int getPhoto(){
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

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

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String name;
    private String genre;
    private String Rating;
    private String description;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Photo);
        dest.writeString(name);
        dest.writeString(genre);
        dest.writeString(Rating);
        dest.writeString(description);
    }
}

package com.example.abdillahsatari.mata.NewsHandler;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abdillah Satari on 4/19/2018.
 */

public class News {
    private int resId;
    private String breed;
    private String description;

    List<News> news = new ArrayList<>();

    public News(){

    }

    @SuppressLint("ValidFragment")
    public News (int resId, String breed, String description){
        this.resId = resId;
        this.breed = breed;
        this.description = description;
    }

    @SuppressLint("ValidFragment")
    public News(int resId, String breed){
        this.resId = resId;
        this.breed = breed;
    }

    public int getResId(){
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}

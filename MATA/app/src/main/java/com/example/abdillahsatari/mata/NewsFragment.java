package com.example.abdillahsatari.mata;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.abdillahsatari.mata.NewsHandler.ListAdapter;
import com.example.abdillahsatari.mata.NewsHandler.News;
import com.example.abdillahsatari.mata.NewsHandler.ShowDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abdillah Satari on 4/14/2018.
 */

public class NewsFragment extends Fragment {

    private ListView listView;
    List<News> news = new ArrayList<>();
    int dataSize;
    public News listNews = new News();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.news, container, false);
        initInstances();
        return v;
    }

    private void initInstances() {
        prepareData();
        ListAdapter adapter = new ListAdapter(getContext(), listNews);
        listView = (ListView) getView().findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listViewClickListener);

    }

    private void prepareData() {
        int resId[] = {R.mipmap.german_shepherd, R.mipmap.labrador_retriever, R.mipmap.blue_dog, R.mipmap.beagle
                , R.mipmap.boxer, R.mipmap.golden_retriever, R.mipmap.poodle, R.mipmap.pug, R.mipmap.siberian_husky,
                R.mipmap.great_dane, R.mipmap.german_shepherd, R.mipmap.labrador_retriever, R.mipmap.blue_dog, R.mipmap.beagle
                , R.mipmap.boxer, R.mipmap.golden_retriever, R.mipmap.poodle, R.mipmap.pug, R.mipmap.siberian_husky,
                R.mipmap.great_dane, R.mipmap.german_shepherd, R.mipmap.labrador_retriever, R.mipmap.blue_dog, R.mipmap.beagle
                , R.mipmap.boxer, R.mipmap.golden_retriever, R.mipmap.poodle, R.mipmap.pug, R.mipmap.siberian_husky,
                R.mipmap.great_dane, R.mipmap.german_shepherd, R.mipmap.labrador_retriever, R.mipmap.blue_dog, R.mipmap.beagle
                , R.mipmap.boxer, R.mipmap.golden_retriever, R.mipmap.poodle, R.mipmap.pug, R.mipmap.siberian_husky,
                R.mipmap.great_dane};

        String breed[] = {"German shepherd", "Labrador retriever", "Bull dog", "Beagle",
                "Boxer", "Golden retriever", "Poodle", "Pug", "Siberian husky",
                "Great dane", "German shepherd", "Labrador retriever", "Bull dog", "Beagle",
                "Boxer", "Golden retriever", "Poodle", "Pug", "Siberian husky",
                "Great dane", "German shepherd", "Labrador retriever", "Bull dog", "Beagle",
                "Boxer", "Golden retriever", "Poodle", "Pug", "Siberian husky",
                "Great dane", "German shepherd", "Labrador retriever", "Bull dog", "Beagle",
                "Boxer", "Golden retriever", "Poodle", "Pug", "Siberian husky",
                "Great dane"};

        String description[] = {getString(R.string.german_shepherd_des), getString(R.string.labrador_retriever_des), getString(R.string.blue_dog_des), getString(R.string.beagle_des)
                , getString(R.string.boxer_des), getString(R.string.golden_des), getString(R.string.poodle_des), getString(R.string.pug_des), getString(R.string.siberian_des)
                , getString(R.string.greatdane_des), getString(R.string.german_shepherd_des), getString(R.string.labrador_retriever_des), getString(R.string.blue_dog_des), getString(R.string.beagle_des)
                , getString(R.string.boxer_des), getString(R.string.golden_des), getString(R.string.poodle_des), getString(R.string.pug_des), getString(R.string.siberian_des)
                , getString(R.string.greatdane_des), getString(R.string.german_shepherd_des), getString(R.string.labrador_retriever_des), getString(R.string.blue_dog_des), getString(R.string.beagle_des)
                , getString(R.string.boxer_des), getString(R.string.golden_des), getString(R.string.poodle_des), getString(R.string.pug_des), getString(R.string.siberian_des)
                , getString(R.string.greatdane_des), getString(R.string.german_shepherd_des), getString(R.string.labrador_retriever_des), getString(R.string.blue_dog_des), getString(R.string.beagle_des)
                , getString(R.string.boxer_des), getString(R.string.golden_des), getString(R.string.poodle_des), getString(R.string.pug_des), getString(R.string.siberian_des)
                , getString(R.string.greatdane_des),};
        dataSize = resId.length;


        Log.d("khem", "dataSize " + resId.length);
        Log.d("khem", "breed " + resId.length);
        Log.d("khem", "description " + resId.length);


        for (int i = 0; i < dataSize; i++) {
            Log.d("khem", " " + i);
            News newss = new News(resId[i], breed[i], description[i]);
            news.add(newss);
        }

        listNews.setNews(news);
    }

    AdapterView.OnItemClickListener listViewClickListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getActivity(), "POSITION:= " + position,
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getActivity(), ShowDetailActivity.class);
            intent.putExtra("resId", listNews.getNews().get(position).getResId());
            intent.putExtra("breed", listNews.getNews().get(position).getBreed());
            intent.putExtra("desc", listNews.getNews().get(position).getDescription());

            startActivity(intent);
        }
    };
}


package com.example.abdillahsatari.mata.NewsHandler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdillahsatari.mata.R;

/**
 * Created by Abdillah Satari on 4/19/2018.
 */

@SuppressLint("ValidFragment")
public class ListAdapter extends BaseAdapter{

    Context context;
    News news;
    public ListAdapter(Context context, News news){
        this.context = context;
        this.news = news;
    }

    public int getCount() {
        if (news == null)
            return 0;
        if (news.getNews()==null)
            return 0;
        return news.getNews().size();
    }


    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        LayoutInflater mInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = mInflater.inflate(R.layout.list_item, parent, false);

        TextView textView = (TextView) view.findViewById(R.id.title);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView textDesc = (TextView) view.findViewById(R.id.desc);

        if (news!=null &&news.getNews()!= null){
            textView.setText(news.getNews().get(position).getBreed());
            imageView.setImageResource(news.getNews().get(position).getResId());
            textDesc.setText(news.getNews().get(position).getDescription());
        }
        return null;
    }
}

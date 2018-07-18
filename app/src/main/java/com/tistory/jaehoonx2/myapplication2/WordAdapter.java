package com.tistory.jaehoonx2.myapplication2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends BaseAdapter {
    Context context;
    ArrayList<Word> data;

    public WordAdapter(Context context, ArrayList<Word> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = View.inflate(context, com.tistory.jaehoonx2.myapplication2.R.layout.word, null);
        }

        TextView word = (TextView) convertView.findViewById(com.tistory.jaehoonx2.myapplication2.R.id.word);
        TextView meaning = (TextView) convertView.findViewById(com.tistory.jaehoonx2.myapplication2.R.id.meaning);

        Word one = data.get(position);

        word.setText(one.getWord());
        meaning.setText(one.getMeaning());

        return convertView;
    }
}

package com.example.quizapp.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.quizapp.R;
import com.example.quizapp.backend.data.Trie;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Trie> modelArrayList;

    MyAdapter(Context context, ArrayList<Trie> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.subject_cardview, container, false);
        TextView name=view.findViewById(R.id.subject_cardview_text);

        Trie trie=modelArrayList.get(position);
        name.setText(trie.name);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, trie.name+"--"+trie.child.get(0).name, Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(view, position);
//        return super.instantiateItem(container, position);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
















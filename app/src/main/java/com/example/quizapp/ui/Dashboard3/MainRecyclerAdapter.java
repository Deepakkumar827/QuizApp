package com.example.quizapp.ui.Dashboard3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.backend.data.Trie;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>{
    private Context context;
    private List<Trie> allSubjectList;
    CardClicked3 listener;
    public MainRecyclerAdapter(Context context, List<Trie> allSubjectList, CardClicked3 listener) {
        this.context = context;
        this.allSubjectList = allSubjectList;
        this.listener=listener;

    }


    @NonNull
    @Override
    public MainRecyclerAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.dashboard3_main_recycler_row_item_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerAdapter.MainViewHolder holder, int position) {
        holder.subjectCardview.setText(allSubjectList.get(position).name);
        List<CardData3>second_recycler_item=new ArrayList<>();
        Trie subject=allSubjectList.get(position);
         for (Trie  chapter: subject.child) {
                    for (Trie type : chapter.child) {
                        second_recycler_item.add(new CardData3("Root", ((Spinner)(((Activity)context).findViewById(R.id.spinner_standard))).getSelectedItem().toString(), subject.name, chapter.name, type.name, -2));
                    }
                }
        setSecondRecyclerItem(holder.secondRecycler, second_recycler_item, listener);

    }

    @Override
    public int getItemCount() {
        return allSubjectList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder{

        TextView subjectCardview;
        RecyclerView secondRecycler;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            subjectCardview = itemView.findViewById(R.id.dashboard3_recycler_subject_title);
            secondRecycler = itemView.findViewById(R.id.dashboard3_second_recycler_id);

        }
    }

    private void setSecondRecyclerItem(RecyclerView recyclerView, List<CardData3> second_recycler_item, CardClicked3 listener){

        SecondRecyclerAdapter itemRecyclerAdapter = new SecondRecyclerAdapter(context, second_recycler_item, listener);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(itemRecyclerAdapter);

    }
}

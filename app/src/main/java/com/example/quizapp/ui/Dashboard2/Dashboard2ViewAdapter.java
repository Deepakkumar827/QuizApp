package com.example.quizapp.ui.Dashboard2;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.backend.Question.Question;
import com.google.firebase.database.DatabaseReference;


import java.util.ArrayList;
import java.util.List;

public class Dashboard2ViewAdapter extends RecyclerView.Adapter<CardViewHolder> {
    ArrayList<CardData> cardDataList;
   // ProgressBar waitProgressbar;
    List<Question> questionList = new ArrayList<>(); ;
    Activity activity;
    CardClicked listener;
    // Timer progressbarTimer;
   // int  progressbarCount=0;
     DatabaseReference databaseReference;


    Dashboard2ViewAdapter(ArrayList<CardData> cardData, Activity activity, CardClicked listener){

        this.listener=listener;
         this.activity=activity;
        this.cardDataList=cardData;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard2_cardview, parent, false);
         //waitProgressbar=parent.getRootView().findViewById(R.id.quiz_manager_progressbar);


        CardViewHolder viewHolder= new CardViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CardData cardData=cardDataList.get(viewHolder.getAdapterPosition());

                listener.onCardClicked(cardDataList.get(viewHolder.getAdapterPosition()));

             }


        });
        return viewHolder;
    }










    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        CardData currentItem=cardDataList.get(position);

 //        holder.cardView.getBackground().setTint(Color.RED);
         holder.standard.setText(currentItem.standard);
        holder.subject.setText(currentItem.subject);
        holder.chapter.setText(currentItem.chapter);
        holder.type.setText(currentItem.type);
        ////need to add for count TODO:
        holder.count.setText(Integer.toString(currentItem.count));


     }

    @Override
    public int getItemCount() {
        return cardDataList.size();
    }
}

class CardViewHolder extends RecyclerView.ViewHolder{

    CardView cardView;
     TextView standard;
    TextView subject;
    TextView chapter;
    TextView type;
    TextView count;


    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView=itemView.findViewById(R.id.board1_cardview_id);

        standard=itemView.findViewById(R.id.standard_cardview_text);
        subject=itemView.findViewById(R.id.subject_cardview_text);
        chapter=itemView.findViewById(R.id.chapter_cardview_text);
        type=itemView.findViewById(R.id.question_type_cardview_text);
        count=itemView.findViewById(R.id.no_of_question_cardview_text);

    }
}

interface CardClicked{
    void onCardClicked(CardData cardData);
}

class CardData{
    String board;
    String standard;
    String subject;
    String chapter;
    String type;
    int count=-1;


    public CardData(String board, String standard, String subject, String chapter, String type, int count) {
        this.board = board;
        this.standard = standard;
        this.subject = subject;
        this.chapter = chapter;
        this.type = type;
        this.count = count;


    }

}
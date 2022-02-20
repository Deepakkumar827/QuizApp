package com.example.quizapp.ui.Dashboard3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;

import java.util.List;

public class SecondRecyclerAdapter extends RecyclerView.Adapter<SecondRecyclerAdapter.SecondRecyclerViewHolder> {

    CardClicked3 listener;

    private Context context;
    private List<CardData3> second_recycler_item_list;

    SecondRecyclerAdapter(Context context, List<CardData3> second_recycler_item_list, CardClicked3 listener){
        this.context=context;
        this.second_recycler_item_list=second_recycler_item_list;
        this.listener=listener;
    }


    @NonNull
    @Override
    public SecondRecyclerAdapter.SecondRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.dashboard3_second_recycler_item, parent, false);
        SecondRecyclerViewHolder viewHolder= new  SecondRecyclerViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CardData3 cardData=second_recycler_item_list.get(viewHolder.getAdapterPosition());

                listener.onCardClicked(second_recycler_item_list.get(viewHolder.getAdapterPosition()));

            }


        });
        return viewHolder;




    }

    @Override
    public void onBindViewHolder(@NonNull SecondRecyclerAdapter.SecondRecyclerViewHolder holder, int position) {
        CardData3 currentItem=second_recycler_item_list.get(position);

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
        return second_recycler_item_list.size();
    }

    public static final class SecondRecyclerViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView standard;
        TextView subject;
        TextView chapter;
        TextView type;
        TextView count;

        public SecondRecyclerViewHolder(@NonNull View cardView) {
            super(cardView);
            cardView=itemView.findViewById(R.id.board1_cardview_id);

            standard=itemView.findViewById(R.id.standard_cardview_text);
            subject=itemView.findViewById(R.id.subject_cardview_text);
            chapter=itemView.findViewById(R.id.chapter_cardview_text);
            type=itemView.findViewById(R.id.question_type_cardview_text);
            count=itemView.findViewById(R.id.no_of_question_cardview_text);
        }
    }

}
interface CardClicked3{
    void onCardClicked(CardData3 cardData);
}

package com.example.techinquiri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoryQuestionAdapter extends RecyclerView.Adapter<StoryQuestionAdapter.MyViewHolder> {

    private Context context;
    private ArrayList questions;
    private OnQuestionListener mOnQuestionListener;

    StoryQuestionAdapter(Context context, ArrayList questions, OnQuestionListener onQuestionListener){
        this.context = context;
        this.questions = questions;
        this.mOnQuestionListener = onQuestionListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.question_item,parent, false);
        return new StoryQuestionAdapter.MyViewHolder(view,mOnQuestionListener);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.question.setText(String.valueOf(questions.get(position)));
    }

    @Override
    public int getItemCount() { return questions.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView question;
        OnQuestionListener onQuestionListener;

        public MyViewHolder(@NonNull View itemView, OnQuestionListener onQuestionListener) {
            super(itemView);
            question = itemView.findViewById(R.id.question);
            this.onQuestionListener = onQuestionListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onQuestionListener.onQuestionClick(getAdapterPosition());
        }
    }

    public interface OnQuestionListener {
        void onQuestionClick(int position);
    }

}

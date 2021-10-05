package com.example.techinquiri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList storyid, storyname, storydesc;
    private OnStoryListener mOnStoryListener;

    CustomAdapter(Context context, ArrayList storyid, ArrayList storyname, ArrayList storydesc, OnStoryListener onStoryListener){
        this.context = context;
        this.storyid = storyid;
        this.storyname = storyname;
        this.storydesc = storydesc;
        this.mOnStoryListener = onStoryListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.story_item,parent, false);
        return new MyViewHolder(view, mOnStoryListener);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.storynametxt.setText(String.valueOf(storyname.get(position)));
        holder.storydesctxt.setText(String.valueOf(storydesc.get(position)));
    }

    @Override
    public int getItemCount() {
        return storyid.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView storyidtxt, storynametxt, storydesctxt;
        OnStoryListener onStoryListener;
        public MyViewHolder(@NonNull View itemView, OnStoryListener onStoryListener) {
            super(itemView);

            storynametxt = itemView.findViewById(R.id.story);
            storydesctxt = itemView.findViewById(R.id.desc);
            this.onStoryListener = onStoryListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onStoryListener.OnStoryClick(getAdapterPosition());
        }
    }
    
    public interface OnStoryListener{
        void OnStoryClick(int position);
    }
}

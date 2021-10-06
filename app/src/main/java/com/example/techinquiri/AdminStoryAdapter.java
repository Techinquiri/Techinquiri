package com.example.techinquiri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminStoryAdapter extends RecyclerView.Adapter<AdminStoryAdapter.MyViewHolder> {

    private Context context;
    private ArrayList storyid, storyname, storydesc;

    AdminStoryAdapter(Context context, ArrayList storyid, ArrayList storyname, ArrayList storydesc){
        this.context = context;
        this.storyid = storyid;
        this.storyname = storyname;
        this.storydesc = storydesc;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.admin_story_item,parent, false);
        return new MyViewHolder(view);

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

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView storyidtxt, storynametxt, storydesctxt;
        ImageButton addBranch, deleteStory;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            storynametxt = itemView.findViewById(R.id.admin_story);
            storydesctxt = itemView.findViewById(R.id.admin_desc);
            addBranch = itemView.findViewById(R.id.add_branch);
            deleteStory = itemView.findViewById(R.id.deleteStory);
        }
    }

}

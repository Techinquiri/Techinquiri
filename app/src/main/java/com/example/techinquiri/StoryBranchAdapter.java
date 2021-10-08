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

public class StoryBranchAdapter extends RecyclerView.Adapter<StoryBranchAdapter.MyViewHolder> {

    private Context context;
    private ArrayList branchname;

    StoryBranchAdapter(Context context, ArrayList branchname){
        this.context = context;
        this.branchname = branchname;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.branch_item,parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.branchnametxt.setText(String.valueOf(branchname.get(position)));
    }

    @Override
    public int getItemCount() {
        return branchname.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView branchnametxt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            branchnametxt = itemView.findViewById(R.id.branchinfo);
        }
    }

}

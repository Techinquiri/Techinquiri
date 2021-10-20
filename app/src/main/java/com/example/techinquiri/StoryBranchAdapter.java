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
    private OnBranchListener mOnBranchListener;

    StoryBranchAdapter(Context context, ArrayList branchname, OnBranchListener onBranchListener){
        this.context = context;
        this.branchname = branchname;
        this.mOnBranchListener = onBranchListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.branch_item,parent, false);
        return new MyViewHolder(view,mOnBranchListener);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.branchnametxt.setText(String.valueOf(branchname.get(position)));
    }

    @Override
    public int getItemCount() {
        return branchname.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView branchnametxt;
        OnBranchListener onBranchListener;
        public MyViewHolder(@NonNull View itemView, OnBranchListener onBranchListener) {
            super(itemView);
            branchnametxt = itemView.findViewById(R.id.branchinfo);
            this.onBranchListener = onBranchListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) { onBranchListener.OnBranchClick(getAdapterPosition()); }
        }

        public interface OnBranchListener{
            void OnBranchClick(int position);
        }

}

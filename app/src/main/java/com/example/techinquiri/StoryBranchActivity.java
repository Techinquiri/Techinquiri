package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.techinquiri.data.dbHandler;

import java.util.ArrayList;

public class StoryBranchActivity extends AppCompatActivity {

    dbHandler db;
    RecyclerView recyclerview;
    String sname;
    ArrayList<String> branchname;
    TextView storyname;
    StoryBranchAdapter storyBranchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_branch);

        Intent intent = getIntent();
        sname = intent.getStringExtra("sname");
        storyname = (TextView) findViewById(R.id.storyname);
        storyname.setText(sname);

        recyclerview = findViewById(R.id.rvBranch);
        db = new dbHandler(this);

        branchname = new ArrayList<>();

        branchInArray(sname);

        storyBranchAdapter = new StoryBranchAdapter(StoryBranchActivity.this, branchname);
        recyclerview.setAdapter(storyBranchAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(StoryBranchActivity.this));


    }

    void branchInArray(String sname)
    {
        int sid = db.getSID(sname);      // function to return storyid
        if(sid == -1)
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Cursor cursor = db.viewBranchByStory(sid);
            if(cursor.getCount()==0)
            {
                Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
            }
            else {
                while(cursor.moveToNext())
                {
                    branchname.add(cursor.getString(0));
                }
            }
        }
    }
}
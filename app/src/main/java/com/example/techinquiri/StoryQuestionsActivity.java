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

public class StoryQuestionsActivity extends AppCompatActivity implements StoryQuestionAdapter.OnQuestionListener {

    String sname,bname,title;
    TextView QHeading;
    dbHandler db;
    RecyclerView recyclerview;
    ArrayList<String> questions;
    StoryQuestionAdapter storyQuestionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_questions);

        Intent intent = getIntent();
        sname = intent.getStringExtra("sname");
        bname = intent.getStringExtra("bname");
        QHeading = (TextView) findViewById(R.id.QHeading);
        title = sname + " : " +bname;
        QHeading.setText(title);

        recyclerview = findViewById(R.id.rvQuestion);
        db = new dbHandler(this);

        questions = new ArrayList<>();

        questionsInArray(bname);

        storyQuestionAdapter = new StoryQuestionAdapter(StoryQuestionsActivity.this, questions, this);
        recyclerview.setAdapter(storyQuestionAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(StoryQuestionsActivity.this));
    }

    void questionsInArray(String bname)
    {
        int bid = db.getBID(bname);      // function to return branchid
        if(bid == -1)
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Cursor cursor = db.viewQuestionsByBranch(bid);
            if(cursor.getCount()==0)
            {
                Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
            }
            else {
                while(cursor.moveToNext())
                {
                    questions.add(cursor.getString(0));
                }
            }
        }
    }


    @Override
    public void onQuestionClick(int position) {
        Intent intent = new Intent(this,StoryContentActivity.class);
        intent.putExtra("question",questions.get(position));
        startActivity(intent);
    }
}
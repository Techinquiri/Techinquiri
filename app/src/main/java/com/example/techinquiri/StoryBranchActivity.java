package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StoryBranchActivity extends AppCompatActivity {

    String storyname;
    TextView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_branch);
        Intent intent = getIntent();
        storyname = intent.getStringExtra("sname");

        test = (TextView) findViewById(R.id.test);
        test.setText(storyname);

    }
}
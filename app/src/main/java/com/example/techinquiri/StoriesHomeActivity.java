package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StoriesHomeActivity extends AppCompatActivity {

    TextView s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stories_home);

        s1 = (TextView)findViewById(R.id.story1);
        s2 = (TextView)findViewById(R.id.story2);
        s3 = (TextView)findViewById(R.id.story3);

        s1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent = new Intent(StoriesHomeActivity.this, StoryQuestionsActivity.class);
                startActivity(intent);
            }
        });
    }
}
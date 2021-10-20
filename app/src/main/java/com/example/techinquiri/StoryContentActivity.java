package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.techinquiri.data.dbHandler;

import java.util.ArrayList;


public class StoryContentActivity extends AppCompatActivity {

    String question;
    TextView questionTitle, answer;
    ArrayList<String> result;
    String ans, isFinal;
    Integer next;
    Button finish;

    dbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_content);

        Intent intent = getIntent();
        question = intent.getStringExtra("question");
        questionTitle = (TextView) findViewById(R.id.textView4);
        questionTitle.setText(question);

        db = new dbHandler(this);
        result = new ArrayList<>();
        result = db.getAnswer(question);
        ans = result.get(0);
        isFinal = result.get(1);
        next = Integer.parseInt(result.get(2));

        answer = (TextView) findViewById(R.id.answer);
        answer.setText(ans);

        finish = (Button) findViewById(R.id.Finish);

        finish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isFinal.equals("no"))
                {
                    Intent intent = new Intent(StoryContentActivity.this, StoryBranchActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(StoryContentActivity.this, RewardActivity.class);
                    intent.putExtra("final", isFinal);
                    intent.putExtra("next", next);
                    startActivity(intent);
                }
            }
        });
    }
}
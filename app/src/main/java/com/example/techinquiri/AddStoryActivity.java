package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.techinquiri.data.dbHandler;

public class AddStoryActivity extends AppCompatActivity {

    Button addStory;
    EditText sname, sdesc;
    dbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_story);

        addStory = (Button) findViewById(R.id.addStory);
        sname = (EditText) findViewById(R.id.StoryName);
        sdesc = (EditText) findViewById(R.id.StoryDesc);
        db = new dbHandler(this);

        addStory.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                String nametxt = sname.getText().toString();
                String desc = sdesc.getText().toString();
                if(nametxt.equals("") || desc.equals(""))
                    Toast.makeText(AddStoryActivity.this, "All fields Required", Toast.LENGTH_SHORT).show();
                else
                {
                    Boolean checkAddStory = db.addStory(nametxt, desc);
                    if(checkAddStory ==true)
                    {
                        Intent intent = new Intent(AddStoryActivity.this,AddBranchActivity.class);
                        startActivity(intent);
                    }
                    else Toast.makeText(AddStoryActivity.this, "Some Error Occured!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
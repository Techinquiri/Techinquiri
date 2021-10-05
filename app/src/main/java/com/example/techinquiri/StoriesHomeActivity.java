package com.example.techinquiri;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.example.techinquiri.data.dbHandler;
import java.util.ArrayList;

public class StoriesHomeActivity extends AppCompatActivity implements CustomAdapter.OnStoryListener {

    RecyclerView recyclerview;
    dbHandler db;
    ArrayList<String> storyid, storyname,storydesc;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stories_home);

        recyclerview = findViewById(R.id.rvStory);
        db = new dbHandler(this);
        db.addStory("Yaksh & Pandavas","Lorem Ipsum");
        db.addStory("Pandora's Box","Lorem Ipsum");
        db.addStory("Squirrel's Efforts for RamSetu","Lorem Ipsum");

        storyid = new ArrayList<>();
        storyname = new ArrayList<>();
        storydesc = new ArrayList<>();

        storiesInArray();

        customAdapter = new CustomAdapter(StoriesHomeActivity.this, storyid, storyname, storydesc, this);
        recyclerview.setAdapter(customAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(StoriesHomeActivity.this));

    }

    void storiesInArray()
    {
        Cursor cursor = db.viewStories();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
        else {
            while(cursor.moveToNext())
            {
                storyid.add(cursor.getString(0));
                storyname.add(cursor.getString(1));
                storydesc.add(cursor.getString(2));
            }
        }
    }

    @Override
    public void OnStoryClick(int position) {
        Intent intent = new Intent(this,StoryBranchActivity.class);
        intent.putExtra("sname",storyname.get(position));
        startActivity(intent);
    }
}
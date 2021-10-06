package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.techinquiri.data.dbHandler;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    Button addStoryBtn;
    dbHandler db;
    ArrayList<String> storyid, storyname,storydesc;
    AdminStoryAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        recyclerview = findViewById(R.id.rvAdminStory);
        db = new dbHandler(this);
        addStoryBtn = (Button) findViewById(R.id.addstorybtn);

        storyid = new ArrayList<>();
        storyname = new ArrayList<>();
        storydesc = new ArrayList<>();

        storiesInArray();

        addStoryBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, AddStoryActivity.class);
                startActivity(intent);
            }
        });

        customAdapter = new AdminStoryAdapter(AdminActivity.this,storyid,storyname,storydesc);
        recyclerview.setAdapter(customAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(AdminActivity.this));
    }

    void storiesInArray()
    {
        Cursor cursor = db.viewStories();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this,"No Data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                storyid.add(cursor.getString(0));
                storyname.add(cursor.getString(1));
                storydesc.add(cursor.getString(2));

            }
        }
    }

}
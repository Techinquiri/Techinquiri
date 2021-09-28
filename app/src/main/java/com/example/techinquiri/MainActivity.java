package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.techinquiri.data.dbHandler;

public class MainActivity extends AppCompatActivity {

    Button skip;
    dbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skip = (Button)findViewById(R.id.textButton);

        skip.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Boolean checkInsert1 = db.insert("Yaksh & Pandavas");
                Boolean checkInsert2 = db.insert("Squirrel's Effort for RamSetu");
                Boolean checkInsert3 = db.insert("Pandora's Box");
                if(checkInsert1==false | checkInsert2==false | checkInsert3==false)
                {
                    Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(MainActivity.this, StoriesHomeActivity.class);
                startActivity(intent);
            }
        });

        db = new dbHandler(this);

    }
}
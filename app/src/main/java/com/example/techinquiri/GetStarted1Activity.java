package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GetStarted1Activity extends AppCompatActivity {

    Button skip,forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_started1);

        skip = (Button)findViewById(R.id.textButton);
        forward = (Button)findViewById(R.id.containedButton);

        skip.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent = new Intent(GetStarted1Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        forward.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent1 = new Intent(GetStarted1Activity.this, GetStarted2Activity.class);
                startActivity(intent1);
            }
        });

    }
}
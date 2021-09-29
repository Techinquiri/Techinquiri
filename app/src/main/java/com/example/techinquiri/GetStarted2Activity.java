package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GetStarted2Activity extends AppCompatActivity {

    Button skip,forward,tnc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_started2);

        skip = (Button)findViewById(R.id.textButton);
        forward = (Button)findViewById(R.id.containedButton);
        tnc = (Button)findViewById(R.id.textButton1);

        skip.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent = new Intent(GetStarted2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        forward.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent1 = new Intent(GetStarted2Activity.this, GetStarted3Activity.class);
                startActivity(intent1);
            }
        });

        tnc.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                CharSequence text = "Will be added soon!";
                Toast toast = Toast.makeText(GetStarted2Activity.this, text , Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
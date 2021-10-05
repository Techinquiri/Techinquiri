package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button loginbtn;
    EditText loginemail, loginpwd;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn = (Button)findViewById(R.id.loginbtn);
        loginemail = (EditText)findViewById(R.id.loginemail);
        loginpwd = (EditText) findViewById(R.id.loginpwd);
        
        loginbtn.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View view) 
            {
                String mail = loginemail.getText().toString();
                String pwd = loginpwd.getText().toString();
                if(mail.equals("testemail") && pwd.equals("testpwd"))
                {
                    Intent intent = new Intent(LoginActivity.this, StoriesHomeActivity.class);
                    startActivity(intent);
                }
                else if(mail.equals("admin@gmail.com") && pwd.equals("adminpwd"))
                {
                    Intent intent = new Intent(LoginActivity.this, AddStoryActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.techinquiri.data.dbHandler;

public class SignupActivity extends AppCompatActivity {

    Button signup;
    dbHandler db;
    EditText name, phone, email, password, cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup = (Button)findViewById(R.id.signup);
        db = new dbHandler(this);
        name = (EditText)findViewById(R.id.fname);
        phone = (EditText)findViewById(R.id.phoneno);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        cpassword = (EditText)findViewById(R.id.confirmPassword);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt = name.getText().toString();
                String phonetxt = phone.getText().toString();
                String emailtxt = email.getText().toString();
                String pwd = password.getText().toString();
                String cpwd = cpassword.getText().toString();

                if (nametxt.equals("") || phonetxt.equals("") || emailtxt.equals("") || pwd.equals("") || cpwd.equals("")) {
                    Toast.makeText(SignupActivity.this, "All Fields are Necessary!", Toast.LENGTH_SHORT).show();
                } else if (!pwd.equals("cpwd")) {
                    Toast.makeText(SignupActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkInsertUser = db.insertUser(nametxt, phonetxt, emailtxt, pwd);
                    if (checkInsertUser == true)
                        Toast.makeText(SignupActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(SignupActivity.this, "Couldn't Register", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
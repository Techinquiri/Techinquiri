package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class AddBranchActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layoutlist;
    Button buttonadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);

        layoutlist = findViewById(R.id.layout_list);
        buttonadd = findViewById(R.id.button_add);

        buttonadd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        addView();
    }

    private void addView() {
        View branchview = getLayoutInflater().inflate(R.layout.branch_row, null, false);
        EditText addBranchName = (EditText) findViewById(R.id.add_branch_name);
        layoutlist.addView(branchview);
    }
}
package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ChoiceOption extends AppCompatActivity implements View.OnClickListener{
    private Button teacher;
    private Button student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_option);
        init();
    }
    public void init(){
        teacher = findViewById(R.id.IMTeacher);
        teacher.setOnClickListener(this);
        student = findViewById(R.id.IMStudent);
        student.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.IMStudent :
                Intent intent = new Intent(ChoiceOption.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.IMTeacher :
                break;
            default:break;

        }

    }
}

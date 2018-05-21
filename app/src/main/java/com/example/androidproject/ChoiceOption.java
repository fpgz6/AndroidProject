package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.Freedom.Login2Activity;
import com.example.Freedom.MeActivity;
import com.example.Freedom.UserSession;
import com.example.teacher.TeacherActivity;

public class ChoiceOption extends AppCompatActivity implements View.OnClickListener{

    // session 相关
    private UserSession usersession;

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
                usersession = (UserSession) getApplicationContext();
                usersession.setPerson("student");
                Intent intent = new Intent(ChoiceOption.this, Login2Activity.class);
                startActivity(intent);
                break;
            case R.id.IMTeacher :
                usersession = (UserSession) getApplicationContext();
                usersession.setPerson("teacher");
                Intent intent1 = new Intent(ChoiceOption.this, Login2Activity.class);
                startActivity(intent1);
                break;
            default:break;

        }

    }
}

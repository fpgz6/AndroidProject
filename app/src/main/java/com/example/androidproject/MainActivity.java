package com.example.androidproject;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import Layout.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button teacher;
    private Button course;
    private Button account;
    private ImageButton search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();

        }
        init();


    }
    private void init() {
        course = (Button)findViewById(R.id.course);
        course.setOnClickListener(this);
        teacher = (Button)findViewById(R.id.teacher);
        teacher.setOnClickListener(this);
        account = (Button) findViewById(R.id.account);
        account.setOnClickListener(this);
        search = (ImageButton)findViewById(R.id.search);
        search.setOnClickListener(this);
        replaceFragment(new ContentTeacherLayout());
    }
   /* public void changeFragmentTeacher(){
        replaceFragment(new ContentTeacherLayout());
    }
    public void changeFragmentCourse(){
        replaceFragment(new ContentCourseLayout());
    }
    public void changeFragmentAccount(){
        replaceFragment(new ContentAccountLayout());
    }*/

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content,fragment);
        transaction.commit();
        /*getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .commit();*/


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.teacher :
                Log.d("woaini","teacher");
                replaceFragment(new ContentTeacherLayout());
                break;
            case R.id.course:
                Log.d("woaini","course");
                replaceFragment(new ContentCourseLayout());
                break;
            case R.id.account:
                Log.d("woaini","account");
                replaceFragment(new ContentAccountLayout());
                break;
            case R.id.search:
                Toast toast = Toast.makeText(MainActivity.this, "This is search Button", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                break;
            default:break;
        }

    }
}

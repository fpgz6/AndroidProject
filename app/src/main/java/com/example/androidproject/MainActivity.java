package com.example.androidproject;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import Layout.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();

        }
        replaceFragment(new ContentTeacherLayout());

    }
    public void changeFragmentTeacher(){
        replaceFragment(new ContentTeacherLayout());
    }
    public void changeFragmentCourse(){
        replaceFragment(new ContentCourseLayout());
    }
    public void changeFragmentAccount(){
        replaceFragment(new ContentAccountLayout());
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content,fragment);
        transaction.commit();
        /*getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .commit();*/


    }
}

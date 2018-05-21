package com.example.teacher;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidproject.R;

import Entity.Teacher;
import Layout.TeacherClassLayout;
import io.vov.vitamio.utils.Log;
import util.JsonTool;
import util.WebService;

public class TeacherActivity extends AppCompatActivity {

    private TextView teacher_name;
    private TextView teacher_gender;
    private TextView teacher_age;
    private TextView teacher_place;
    private TextView teacher_subject;
    private String teacher_id;
    private  String result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_total);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();

        }
        Intent intent=this.getIntent();
       // teacher_id=intent.getStringExtra("teacher_id");
        /*
        Thread thread=new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                result= WebService.executeHttpGetP1("teacher.do","get_teacher_by_tid",teacher_id);

            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e("result",result);
        teacher_name = findViewById(R.id.detail_teacher_name);
        teacher_gender = findViewById(R.id.detail_teacher_gender);
        teacher_age = findViewById(R.id.detail_teacher_age);
        teacher_place = findViewById(R.id.detail_teacher_place);
        teacher_subject = findViewById(R.id.detail_teacher_subject);
        Teacher teacher= JsonTool.getTeacher("teacher",result);
        teacher_name.setText("123");
        teacher_gender.setText(teacher.getGender());
        teacher_age.setText(teacher.getAge());
        teacher_place.setText(teacher.getRegion());
        teacher_subject.setText(teacher.getSubject());
        */
        init();
    }

    private void init() {
        replaceFragment(new TeacherClassLayout());


    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.teacher_information_course,fragment);
        transaction.commit();

    }

}

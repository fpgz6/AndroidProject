package com.example.androidproject;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import Layout.TeacherContentCommentLayout;
import Layout.TeacherContentLayout;

public class TeacherDetailTotal extends AppCompatActivity /*implements View.OnClickListener*/{

    private Button teacher_intro;
    private Button teacher_comment;
    private View view_left;
    private View view_right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_detail_total);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();

        }
        init();
        teacher_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("123","123");
                ChangeToIntro();
                replaceFragment(new TeacherContentLayout());

            }
        });
        teacher_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("123","123");
                ChangeToComment();
                replaceFragment(new TeacherContentCommentLayout());
            }
        });
    }

    public void init(){
        teacher_intro = (Button)findViewById(R.id.teacher_intro);
        teacher_comment = (Button)findViewById(R.id.teacher_comment);
        view_left = (View)findViewById(R.id.view_left);
        view_right = (View)findViewById(R.id.view_right);
        replaceFragment(new TeacherContentLayout());
        teacher_intro.setTextColor(Color.parseColor("#EE7700"));
        view_left.setBackgroundColor(Color.parseColor("#EE7700"));

    }
    public void ChangeToComment(){
        teacher_intro.setTextColor(Color.parseColor("#888888"));
        view_left.setBackgroundColor(Color.parseColor("#888888"));
        teacher_comment.setTextColor(Color.parseColor("#EE7700"));
        view_right.setBackgroundColor(Color.parseColor("#EE7700"));
    }
    public void ChangeToIntro(){
        teacher_intro.setTextColor(Color.parseColor("#EE7700"));
        view_left.setBackgroundColor(Color.parseColor("#EE7700"));
        teacher_comment.setTextColor(Color.parseColor("#888888"));
        view_right.setBackgroundColor(Color.parseColor("#888888"));

    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.teacher_content,fragment);
        transaction.commit();

    }

   /* @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.teacher_intro:Log.d("123","123"); ChangeToIntro();replaceFragment(new TeacherContentLayout());break;
            case R.id.teacher_comment:Log.d("123","123");ChangeToComment();replaceFragment(new TeacherContentCommentLayout());break;
            default:break;
        }
    }*/
}

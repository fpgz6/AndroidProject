package com.example.Freedom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidproject.R;

import Entity.Student;
import Entity.Teacher;
import util.JsonTool;
import util.WebService;

public class InfoActivity extends AppCompatActivity {

    // session 相关
    private UserSession usersession;
    private String name;
    private String pwd;
    private String realname;
    private String gender;
    private String age;
    private String grade;
    private String person;

    private Button mButton;
    private EditText mEditTextId;
    private EditText mEditTextPassword;
    private EditText mEditTextName;
    private EditText mEditTextGender;
    private EditText mEditTextAge;
    private EditText mEditTextGrade;
    private TextView mTextViewGrade;

    private String result="";

    private Teacher teacher=null;
    private Student student=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        usersession = (UserSession) getApplicationContext();
        name = usersession.getUsername();
        Log.e("全局变量name",name);
        pwd = usersession.getPassword();
        person = usersession.getPerson();

        //从数据库获取
        if (person.equals("teacher")){

            Thread thread=new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    result= WebService.executeHttpGetP1("teacher.do","get_teacher",name);

                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            teacher= JsonTool.getTeacher("teacher", result);

            //填表单
            mEditTextId = (EditText) findViewById(R.id.editText_info_id);
            mEditTextId.setText(name);

            mEditTextPassword = (EditText) findViewById(R.id.editText_info_password);
            mEditTextPassword.setText(pwd);

            mEditTextName = (EditText) findViewById(R.id.editText_info_name);
            mEditTextName.setText(teacher.getName());

            mEditTextGender = (EditText) findViewById(R.id.editText_info_gender);
            mEditTextName.setText(teacher.getGender());

            mEditTextAge = (EditText) findViewById(R.id.editText_info_age);
            mEditTextAge.setText(teacher.getAge());

        }
        else if (person.equals("student")){
            Thread thread=new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    result=WebService.executeHttpGetP1s("student.do","get_student",name);

                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.e("result",result);

            student=JsonTool.getStudent("student", result);
            Log.e("学生姓名信息",student.getName());

            //填表单
            mEditTextId = (EditText) findViewById(R.id.editText_info_id);
            mEditTextId.setText(name);

            mEditTextPassword = (EditText) findViewById(R.id.editText_info_password);
            mEditTextPassword.setText(pwd);

            mEditTextName = (EditText) findViewById(R.id.editText_info_name);
            mEditTextName.setText(student.getName());

            mEditTextGender = (EditText) findViewById(R.id.editText_info_gender);
            mEditTextName.setText(student.getGender());

            mEditTextAge = (EditText) findViewById(R.id.editText_info_age);
            mEditTextAge.setText(student.getAge());

            mEditTextGrade = (EditText) findViewById(R.id.editText_info_grade);
            mEditTextGrade.setText(student.getGrade());

        }
        else {
            Log.e("修改个人信息——错误情况","不是student也不是teacher");
        }





        //获取表单内容
        if (person.equals("teacher")) {
            mEditTextGrade = (EditText) findViewById(R.id.editText_info_grade);
            mEditTextGrade.setVisibility(View.GONE);

            mTextViewGrade = (TextView) findViewById(R.id.textView_info_grade);
            mTextViewGrade.setVisibility(View.GONE);

            mButton = (Button) findViewById(R.id.button_info_submit);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    name = mEditTextId.getText().toString();
                    pwd = mEditTextPassword.getText().toString();

                    mEditTextName = (EditText) findViewById(R.id.editText_info_name);
                    realname = mEditTextName.getText().toString();

                    mEditTextGender = (EditText) findViewById(R.id.editText_info_gender);
                    gender = mEditTextGender.getText().toString();

                    mEditTextAge = (EditText) findViewById(R.id.editText_info_age);
                    age = mEditTextAge.getText().toString();

                    Log.e("修改个人信息1",name);
                    Log.e("修改个人信息2",pwd);
                    Log.e("修改个人信息3",realname);
                    Log.e("修改个人信息4",gender);
                    Log.e("修改个人信息5",age);

                    //Intent intent = new Intent(InfoActivity.this,MainActivity.class);
                    //startActivity(intent);
                }
            });
        }
        else if (person.equals("student")){
            mButton = (Button) findViewById(R.id.button_info_submit);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    name = mEditTextId.getText().toString();
                    pwd = mEditTextPassword.getText().toString();

                    mEditTextName = (EditText) findViewById(R.id.editText_info_name);
                    realname = mEditTextName.getText().toString();

                    mEditTextGender = (EditText) findViewById(R.id.editText_info_gender);
                    gender = mEditTextGender.getText().toString();

                    mEditTextAge = (EditText) findViewById(R.id.editText_info_age);
                    age = mEditTextAge.getText().toString();

                    mEditTextGrade = (EditText) findViewById(R.id.editText_info_grade);
                    grade = mEditTextGrade.getText().toString();

                    Log.e("修改个人信息1",name);
                    Log.e("修改个人信息2",pwd);
                    Log.e("修改个人信息3",realname);
                    Log.e("修改个人信息4",gender);
                    Log.e("修改个人信息5",age);
                    Log.e("修改个人信息6",grade);

                    //Intent intent = new Intent(InfoActivity.this,MainActivity.class);
                    //startActivity(intent);
                }
            });
        }
        else {
            Log.e("修改个人信息——错误情况","不是student也不是teacher");
        }



    }
}

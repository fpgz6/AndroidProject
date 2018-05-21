package com.example.Freedom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidproject.MainActivity;
import com.example.androidproject.R;
import com.example.teacher.TeacherActivity;

import util.WebService;

public class Login2Activity extends AppCompatActivity {

    private AutoCompleteTextView mphone;
    private EditText mpassword;
    private Button msignin;
    private Button mregister;
    private String result;
    private String person;

    // session 相关
    private UserSession usersession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.content_login2);

        usersession = (UserSession) getApplicationContext();
        person = usersession.getPerson();

        msignin = (Button) findViewById(R.id.sign_in_button);
        msignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mphone = (AutoCompleteTextView) findViewById(R.id.phone);
                final String phone = mphone.getText().toString();
                mpassword = (EditText) findViewById(R.id.password);
                final String password = mpassword.getText().toString();

                Thread thread=new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        result= WebService.executeHttpGetP3s("login.do",person,phone,password);
                        //Message message=new Message();
                        //message.what=1;
                        //mHandler.sendMessage(message);
                    }
                });
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
Log.e("2222222222222222",result);
                if (result.equals("1")) {
                    usersession = (UserSession) getApplicationContext();
                    Log.e("2222222222222222",phone);
                    usersession.setUsername(phone);
                    usersession.setPassword(password);

                    if(person.equals("student")){
                        Intent intent = new Intent(Login2Activity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(Login2Activity.this,TeacherActivity.class);
                        startActivity(intent);
                    }

                }
                else if (result.equals("0")) {
                    mphone.setError(getString(R.string.error_invalid_phone));
                    mphone.requestFocus();
                }
            }
        });

        mregister = (Button) findViewById(R.id.register_button);
        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mphone = (AutoCompleteTextView) findViewById(R.id.phone);
                final String phone = mphone.getText().toString();
                mpassword = (EditText) findViewById(R.id.password);
                final String password = mpassword.getText().toString();

                Thread thread=new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        result=WebService.executeHttpGetP3s("register.do",person,phone,password);
                        //Message message=new Message();
                        //message.what=1;
                        //mHandler.sendMessage(message);
                    }
                });
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (result.equals("1")) {
                    usersession = (UserSession) getApplicationContext();
                    usersession.setUsername(phone);
                    usersession.setPassword(password);

                    if(person.equals("student")){
                        Intent intent = new Intent(Login2Activity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(Login2Activity.this,TeacherActivity.class);
                        startActivity(intent);
                    }


                }
                else if (result.equals("0")) {
                    mphone.setError(getString(R.string.error_invalid_register));
                    mphone.requestFocus();
                }


            }
        });



    }

}

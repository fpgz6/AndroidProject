package com.example.Freedom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.androidproject.R;

public class MeActivity extends AppCompatActivity {

    //UI相关
    private TextView mTextMessage;
    private ImageButton mImageButton;
    private RelativeLayout relativeLayout;
    private TextView mTextViewLogin;
    private TextView mTextViewOrder;
    private TextView mTextViewLogout;

    //session相关
    private UserSession usersession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        usersession = (UserSession) getApplicationContext();

        if(usersession.getUsername() == null) {
            Log.e("我的界面","session为空");
            mTextViewOrder = (TextView) findViewById(R.id.textView_order);
            mTextViewOrder.setVisibility(View.GONE);
            mTextViewLogout = (TextView) findViewById(R.id.textView_logout);
            mTextViewLogout.setVisibility(View.GONE);
            relativeLayout = (RelativeLayout) findViewById(R.id.login_relativelayout);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MeActivity.this, Login2Activity.class);
                    startActivity(intent);
                }
            });
        }
        else
        {
            Log.e("我的界面","session不为空");
            mTextViewLogin = (TextView) findViewById(R.id.textView_login);
            mTextViewLogin.setText(usersession.getUsername());
            mTextViewLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MeActivity.this, ForgetActivity.class);
                    startActivity(intent);
                }
            });
            mTextViewOrder = (TextView) findViewById(R.id.textView_order);
            mTextViewOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MeActivity.this, OrderActivity.class);
                    startActivity(intent);
                }
            });
            mTextViewLogout = (TextView) findViewById(R.id.textView_logout);
            mTextViewLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usersession.setUsername(null);
                    usersession.setPassword(null);
                    recreate();
                }
            });
        }



    }
}

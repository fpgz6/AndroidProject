package com.example.androidproject;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        TextView textView1 = (TextView) findViewById(R.id.teacher); textView1.setText("李老师");
        TextView textView2 = (TextView) findViewById(R.id.needmoney); textView2.setText("100元");
        initEvent();
    }
    private void initEvent() {
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
                switch (view.getId()) {
                    case R.id.button:
                        final ProgressDialog progressDialog = new ProgressDialog(Payment.this);
                        progressDialog.setTitle("正在支付");
                        progressDialog.setMessage("Loading……");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                try {
                                    Thread.sleep(3000);//休眠3秒

                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                progressDialog.dismiss();
                            }
                        }.start();
                        break;
                    default:
                        break;
                }

            }
        });
    }

    private void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("温馨提示");
        builder.setMessage("支付成功！");
        builder.setPositiveButton("我知道了",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Payment.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();

    }
}

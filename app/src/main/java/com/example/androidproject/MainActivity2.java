package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.androidproject.R;

import java.util.ArrayList;
import java.util.List;

import io.vov.vitamio.utils.Log;

public class MainActivity2 extends AppCompatActivity {

    private CheckBox[] checkbox = new CheckBox[16];
    private RadioButton man, woman;
    private List<CheckBox> checkBoxList = new ArrayList<CheckBox>();
    private List<Boolean> grade=new ArrayList<Boolean>();
    private Boolean[]  allItem = new Boolean[16];
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        final ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }

        Button titleBack = (Button) findViewById(R.id.title_back);
        Button titleEdit = (Button) findViewById(R.id.title_edit);

        //初始化控件

        checkbox[0]=(CheckBox) findViewById(R.id.lianjibuxian);
        checkbox[1]=(CheckBox) findViewById(R.id.gaoyi);
        checkbox[2]=(CheckBox) findViewById(R.id.gaoer);
        checkbox[3]=(CheckBox) findViewById(R.id.gaosan);
        checkbox[4]=(CheckBox) findViewById(R.id.kemubuxian);
        checkbox[5]=(CheckBox) findViewById(R.id.wuli);
        checkbox[6]=(CheckBox) findViewById(R.id.shuxue);
        checkbox[7]=(CheckBox) findViewById(R.id.huaxue);
        checkbox[8]=(CheckBox) findViewById(R.id.yi);
        checkbox[9]=(CheckBox) findViewById(R.id.er);
        checkbox[10]=(CheckBox) findViewById(R.id.san);
        checkbox[11]=(CheckBox) findViewById(R.id.si);
        checkbox[12]=(CheckBox) findViewById(R.id.yibai);
        checkbox[13]=(CheckBox) findViewById(R.id.liangbai);
        checkbox[14]=(CheckBox) findViewById(R.id.sanbai);
        checkbox[15]=(CheckBox) findViewById(R.id.jiagebuxian);

        man = (RadioButton) findViewById(R.id.male);
        woman = (RadioButton) findViewById(R.id.female);

        for(int i=0;i<16;i++){
            checkBoxList.add(checkbox[i]);
        }


        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回上一界面

            }
        });
        titleEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //确认信息，刷新listview
                /*StringBuffer sb = new StringBuffer();*/
                int num = 0;
                for (int i = 0 ;i<checkbox.length;i++) {
                    if (checkbox[i].isChecked()) {
                        allItem[i] = true;
                    }else{
                        allItem[i] = false;
                    }
                }
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }

    }


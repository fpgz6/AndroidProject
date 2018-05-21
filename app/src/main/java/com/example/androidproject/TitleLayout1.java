package com.example.androidproject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MECHREVO on 2018/5/21.
 */


public class TitleLayout1 extends LinearLayout {

   /* private CheckBox[] checkbox;
    private RadioButton man, woman;
    private List<CheckBox> checkBoxList = new ArrayList<CheckBox>();
    private List<Boolean> grade=new ArrayList<Boolean>();*/

    public TitleLayout1(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title1, this);
       /* Button titleBack = (Button) findViewById(R.id.title_back);
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
*/

     /*   titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回上一界面

            }
        });
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You clicked Edit button",
                        Toast.LENGTH_SHORT).show();
                //确认信息，刷新listview
                StringBuffer sb = new StringBuffer();
                for (CheckBox checkbox : checkBoxList) {
                    if (checkbox.isChecked()) {
                        sb.append(checkbox.getText().toString() + "-");
                    }
                }
               System.out.print(sb);

            }
        });*/
    }

}

package Layout;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.androidproject.MainActivity;
import com.example.androidproject.Payment;
import  com.example.androidproject.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import rtmppush.hx.com.rtmppush.MActivity;
import rtmppush.hx.com.rtmppush.StartActivity;

/**
 * Created by MECHREVO on 2018/5/17.
 */

public class TeacherContentLayout extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.classdetail_content,container,false);
        Button button = view.findViewById(R.id.start_class);
        button.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Date currentTime = new Date();//currentTime就是系统当前时间
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strBeginTime="2018-01-01 00:00:00";
                String strEndTime="2019-01-01 00:00:00";
                Date strbeginDate = null;//起始时间
                Date strendDate = null;//结束时间
                try {
                    strbeginDate = fmt.parse(strBeginTime.toString());//将时间转化成相同格式的Date类型
                    strendDate = fmt.parse(strEndTime.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if ((currentTime.getTime() - strbeginDate.getTime()) > 0 && (strendDate.getTime() - currentTime.getTime()) > 0) {//使用.getTime方法把时间转化成毫秒数,然后进行比较
                    Intent intent = new Intent(getContext(), StartActivity.class);
                    String id ="student";
                    intent .putExtra("id", id);
                    startActivity(intent);
                }
                else{
                    showDialog();
                }
            }
        });
        return view;
    }
    private void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setTitle("温馨提示");
        builder.setMessage("未到上课时间");
        builder.setPositiveButton("我知道了",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();

    }
}

package Adapter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidproject.R;

import java.security.AccessController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Entity.Teacher;
import Entity.TeacherClass;

/**
 * Created by MECHREVO on 2018/5/20.
 */

public class TeacherCourseAdapter extends RecyclerView.Adapter<TeacherCourseAdapter.ViewHolder>{
    private List<TeacherClass> mTeacherClassList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView teacherClassName;
        TextView teacherClassDate;
        TextView teacherClassTime;
        View TeacherView;

        public ViewHolder(View view) {
            super(view);
            TeacherView = view;
            teacherClassName = view.findViewById(R.id.teacher_course_name);
            teacherClassDate = view.findViewById(R.id.teacher_course_day);
            teacherClassTime = view.findViewById(R.id.teacher_course_time);
        }
    }

    public TeacherCourseAdapter(List<TeacherClass> mTeacherClassList) {
        this.mTeacherClassList = mTeacherClassList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_information_couser_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.TeacherView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                TeacherClass teacherClass = mTeacherClassList.get(position);
                Date currentTime = new Date();//currentTime就是系统当前时间
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strBeginTime="2019-01-01 00:00:00";
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
                    //跳转到直播界面
                }
                else{

                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TeacherClass teacherClass = mTeacherClassList.get(position);
        holder.teacherClassName.setText(teacherClass.getCourse_name());
        holder.teacherClassDate.setText(teacherClass.getCourse_date());
        holder.teacherClassDate.setText(teacherClass.getCourse_Time());

    }

    @Override
    public int getItemCount() {
        return mTeacherClassList.size();
    }

}

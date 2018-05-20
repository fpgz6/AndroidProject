package Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidproject.R;

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

        public ViewHolder(View view) {
            super(view);
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
        ViewHolder holder = new ViewHolder(view);
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

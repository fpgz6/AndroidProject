package Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidproject.R;

import java.util.List;

import Entity.MyCourse;

/**
 * Created by MECHREVO on 2018/5/14.
 */

public class MyClassAdapter extends RecyclerView.Adapter<MyClassAdapter.ViewHolder> {
    private List<MyCourse> mCourseList;



    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView course_type;
        TextView course_teacher;
        TextView course_time;

        public ViewHolder(View view) {
            super(view);
            course_type = (TextView)view.findViewById(R.id.course_type);
            course_teacher =  (TextView)view.findViewById(R.id.course_teacher);
            course_time =  (TextView)view.findViewById(R.id. course_time);
        }
    }

    public MyClassAdapter(List<MyCourse> mCourseList) {
        this.mCourseList = mCourseList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_me,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyCourse myCourse = mCourseList.get(position);
        holder.course_teacher.setText(myCourse.getType());
        holder.course_type.setText(myCourse.getType());
        holder.course_time.setText(myCourse.getTime());

    }

    @Override
    public int getItemCount() {
       return mCourseList.size();
    }

}

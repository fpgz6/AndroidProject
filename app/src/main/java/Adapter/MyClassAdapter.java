package Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidproject.ChoiceOption;
import com.example.androidproject.R;
import com.example.androidproject.StartPage;
import com.example.androidproject.TeacherDetailTotal;

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
        View myclassView;

        public ViewHolder(View view) {
            super(view);
            myclassView = view;
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
       //ViewHolder holder = new ViewHolder(view);
        final ViewHolder holder = new ViewHolder(view);
        holder.myclassView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                MyCourse myCourse = mCourseList.get(position);
                String name = myCourse.getTeacher();
                Intent intent  = new Intent(holder.myclassView.getContext(),TeacherDetailTotal.class);
                intent.putExtra("name",name);
                holder.myclassView.getContext().startActivity(intent);
               /* Toast.makeText(view.getContext(),"you clicked view"+myCourse.getTeacher(),Toast.LENGTH_SHORT).show();;*/
            }
        });
        return  holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyCourse myCourse = mCourseList.get(position);
        holder.course_teacher.setText(myCourse.getTeacher());
        holder.course_type.setText(myCourse.getType());
        holder.course_time.setText(myCourse.getTime());

    }

    @Override
    public int getItemCount() {
       return mCourseList.size();
    }

}

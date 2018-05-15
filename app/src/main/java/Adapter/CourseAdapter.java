package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.androidproject.R;

import com.example.androidproject.R;

import java.util.List;

import Entity.CourseView;

/**
 * Created by JAY on 2018/5/2.
 */

public class CourseAdapter extends ArrayAdapter<CourseView> {

    private int recourceId;

    public CourseAdapter(@NonNull Context context, int resourceId, @NonNull List<CourseView> objects) {
        super(context, resourceId, objects);
        this.recourceId=resourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CourseView courseView= (CourseView) getItem(position);//获取当前项的CourseView实例

       /* View view= LayoutInflater.from(getContext()).inflate(recourceId,parent,false);*/
        View view ;
        if(convertView==null){
            view=LayoutInflater.from(getContext()).inflate(recourceId,parent,false);
        }else {
            view=convertView;
        }
        ImageView courseImage=(ImageView) view.findViewById(R.id.course_img);
        TextView courseName=(TextView)view.findViewById(R.id.course_name);
        TextView coursePrice=(TextView)view.findViewById(R.id.course_price);
        TextView courseSubject=(TextView)view.findViewById(R.id.course_subject);
        TextView courseTime=(TextView)view.findViewById(R.id.course_time);
        TextView courseComment=(TextView)view.findViewById(R.id.course_comment);

        courseImage.setImageResource(courseView.getPic_src());
        courseName.setText(courseView.getName());
        coursePrice.setText(String.valueOf(courseView.getHour_price()));
        courseSubject.setText(courseView.getSubject());
        courseTime.setText(String.valueOf(courseView.getTime()));
        courseComment.setText(String.valueOf(courseView.getComment()));

        return view;
    }
}

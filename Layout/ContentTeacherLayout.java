package Layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.androidproject.Payment;
import com.example.androidproject.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.CourseAdapter;
import Entity.CourseView;


/**
 * Created by MECHREVO on 2018/4/26.
 */


public class ContentTeacherLayout extends Fragment {
    @Nullable
    private List<CourseView> courseViewList=new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_teacher,container,false);

        ListView listView=(ListView)view.findViewById(R.id.list_item);
        initCourseInfo();
        CourseAdapter adapter=new CourseAdapter(getActivity(),R.layout.course_item,courseViewList);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             //   CourseView courseView=courseViewList.get(i);
            //    Toast.makeText(getActivity(),courseView.getName(),Toast.LENGTH_SHORT).show();

               Intent intent = new Intent(getActivity(),Payment.class);
                startActivity(intent);
            }
        });


        return view;


    }

    private void initCourseInfo(){
        for(int i=0;i<10;i++){
            CourseView courseView1=new CourseView(R.drawable.apple_pic,"马立新",48,96,"安卓开发",99);
            courseViewList.add(courseView1);
        }
    }
}

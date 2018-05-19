package Layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import  com.example.androidproject.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Adapter.MyClassAdapter;
import Calendar.NewCalendar;
import Entity.MyCourse;


/**
 * Created by MECHREVO on 2018/4/26.
 */

public class ContentCourseLayout extends Fragment implements NewCalendar.NewCalendarListener{
    @Nullable

    MyClassAdapter adapter;
    private List<MyCourse> myCourseList = new ArrayList<MyCourse>();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        //加在课程recycleView
        View view = inflater.inflate(R.layout.content_course,container,false);
        initMyClass();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.course_detail);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyClassAdapter(myCourseList);
        recyclerView.setAdapter(adapter);

        //加在日历点击
        NewCalendar calendar = (NewCalendar) view.findViewById(R.id.newCalendar);
        calendar.listener = this;

        return view;
    }

    private void initMyClass() {
        for(int i=0;i<10;i++){
            MyCourse courseView1=new MyCourse("1","马立新","14:00-15:00","安卓开发");
            myCourseList.add(courseView1);
        }
    }

    public void changeArrayList(Date day){
       myCourseList.clear();

        for(int i=0;i<10;i++){
            MyCourse courseView1=new MyCourse("1","马立","14:00-15:00","安发");
            myCourseList.add(courseView1);
        }
        adapter.notifyDataSetChanged();



    }

    @Override
    public void onItemPress(Date day) {

        DateFormat df = SimpleDateFormat.getDateInstance();
        Toast.makeText(getActivity(),df.format(day),Toast.LENGTH_SHORT).show();
        changeArrayList(day);
    }
}

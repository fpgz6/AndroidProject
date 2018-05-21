package Layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import Entity.Reservation;
import util.JsonTool;
import util.WebService;


/**
 * Created by MECHREVO on 2018/4/26.
 */

public class ContentCourseLayout extends Fragment implements NewCalendar.NewCalendarListener{
    @Nullable

            private String info="";
    MyClassAdapter adapter;
    private List<MyCourse> myCourseList = new ArrayList<MyCourse>();
    private List<MyCourse> myCourseList2 = new ArrayList<MyCourse>();
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

        Thread thread=new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                info=WebService.executeHttpGetP1s("reservation.do", "get_list_by_sid" ,"S001");
                //Message message=new Message();
                //message.what=1;
                //mHandler.sendMessage(message);
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Reservation> list= JsonTool.getAllReservation("s_lists",info);
        Log.e("返回",info);
        for(int i=0;i<list.size();i++){
            Reservation r=list.get(i);
            MyCourse courseView1=new MyCourse(r.getTeacher_id(),r.getT_name(),r.getDate(),r.getContent());
            myCourseList.add(courseView1);
        }
        for(int i=0;i<myCourseList.size();i++){
            MyCourse courseView1=myCourseList.get(i);
            myCourseList2.add(courseView1);
        }
    }

    public void changeArrayList(Date day){
       myCourseList.clear();
       for(int i = 0;i<myCourseList2.size();i++){
           myCourseList.add(myCourseList2.get(i));
           Log.d("mycourseList",myCourseList.get(i).getTime());
       }

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String str=sdf.format(day);
        Log.d("click",str);
        //int m = myCourseList.size();
       for(int i=0;i< myCourseList.size();i++){
           Log.d("123",myCourseList.get(i).getTime());
            if(myCourseList.get(i).getTime().equals(str)){}
             else{Log.d("remove",myCourseList.get(i).getTime());myCourseList.remove(i);i--;}
        }
        adapter.notifyDataSetChanged();



    }

    @Override
    public void onItemPress(Date day) {
        changeArrayList(day);
    }
}

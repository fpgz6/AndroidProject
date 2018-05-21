package Layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import  com.example.androidproject.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.TeacherCourseAdapter;
import Entity.Reservation;
import Entity.TeacherClass;
import util.JsonTool;
import util.WebService;

/**
 * Created by MECHREVO on 2018/5/20.
 */

public class TeacherClassLayout extends Fragment {

    private String info="";
    private List<TeacherClass> teacherClasseList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teacher_infomation_course,container,false);
        initTeacherClass();
        RecyclerView recyclerView = view.findViewById(R.id.teacher_class_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        TeacherCourseAdapter adapter = new TeacherCourseAdapter(teacherClasseList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initTeacherClass() {
        //通过学生id拿到list
        Thread thread=new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                info= WebService.executeHttpGetP1("reservation.do", "get_list_by_tid" ,"T001");

            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Reservation> list= JsonTool.getAllReservation("t_lists",info);
        Log.e("返回",info);
        for(int i = 0;i<list.size(); i++){
            Reservation r=list.get(i);
            TeacherClass courseView1=new TeacherClass(r.getContent(),r.getDate(),String.valueOf(r.getPeriod()));
            teacherClasseList.add(courseView1);
        }
    }

//laoshi
}

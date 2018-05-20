package Layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import  com.example.androidproject.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.TeacherCourseAdapter;
import Entity.TeacherClass;

/**
 * Created by MECHREVO on 2018/5/20.
 */

public class TeacherClassLayout extends Fragment {

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
        for(int i = 0;i<10; i++){
            TeacherClass courseView1=new TeacherClass("安卓","2018/5/20","14:00-15:00");
            teacherClasseList.add(courseView1);
        }
    }


}

package Layout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import Entity.Reservation;
import util.WebService;

import static util.JsonTool.getAllReservation;


/**
 * Created by MECHREVO on 2018/4/26.
 */


public class ContentTeacherLayout extends Fragment {
    @Nullable
    private String info="";
    private List<CourseView> courseViewList=new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_teacher,container,false);

        ListView listView=(ListView)view.findViewById(R.id.list_item);
        Thread thread=new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                info = WebService.executeHttpGet("reservation.do","get_all_lists");
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e("infooooo",info);
        ArrayList<Reservation> list=getAllReservation("all_lists", info);


        initCourseInfo(list);
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


    private void initCourseInfo(ArrayList<Reservation> list){
        for(int i=0;i<list.size();i++){
            Reservation r=list.get(i);
            CourseView courseView1=new CourseView(R.drawable.apple_pic,r.getTeacher_id(),r.getPrice(),r.getDate(),r.getContent(),r.getComment());
            courseViewList.add(courseView1);
        }
    }
}

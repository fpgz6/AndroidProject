package Layout;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import  com.example.androidproject.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Adapter.CommentAdapter;
import Entity.Comment;
import Entity.Reservation;
import rtmppush.hx.com.rtmppush.StartActivity;
import util.JsonTool;
import util.WebService;

/**
 * Created by MECHREVO on 2018/5/17.
 */

public class TeacherContentCommentLayout extends Fragment{
    private List<Comment> commentList = new ArrayList<Comment>();
    private Button start_comment_class;
private String info;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.classdetail_content_comment,container,false);
        initComment();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.classdetail_comment);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        CommentAdapter adapter = new CommentAdapter(commentList);
        recyclerView.setAdapter(adapter);
        start_comment_class = view.findViewById(R.id.start_comment_class);
        start_comment_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date currentTime = new Date();//currentTime就是系统当前时间
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strBeginTime="2018-01-01 00:00:00";
                String strEndTime="2019-01-01 00:00:00";
                Date strbeginDate = null;//起始时间
                Date strendDate = null;//结束时间
                Intent intent=getActivity().getIntent();
                String teacher_id="T001";
                io.vov.vitamio.utils.Log.d("1234","1234");
                try {
                    strbeginDate = fmt.parse(strBeginTime.toString());//将时间转化成相同格式的Date类型
                    strendDate = fmt.parse(strEndTime.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if ((currentTime.getTime() - strbeginDate.getTime()) > 0 && (strendDate.getTime() - currentTime.getTime()) > 0) {//使用.getTime方法把时间转化成毫秒数,然后进行比较
                    Intent intent1 = new Intent(view.getContext(), StartActivity.class);
                    intent1 .putExtra("id",teacher_id);
                    view.getContext().startActivity(intent1);
                }
                else{

                }
            }
        });

        return view;
    }

    private void initComment() {
        Thread thread=new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                //用老师工号去取课程
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
        for(int i=0;i<list.size();i++){
            Reservation r=list.get(i);
            Comment courseView1=new Comment(r.getStudent_id(),r.getComment(),r.getMark(),r.getStudent_id());
           commentList.add(courseView1);
        }
//123
    }
}

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

import Adapter.CommentAdapter;
import Entity.Comment;
import Entity.Reservation;
import util.JsonTool;
import util.WebService;

/**
 * Created by MECHREVO on 2018/5/17.
 */

public class TeacherContentCommentLayout extends Fragment{
    private List<Comment> commentList = new ArrayList<Comment>();
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

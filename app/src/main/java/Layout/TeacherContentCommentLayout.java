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

import Adapter.CommentAdapter;
import Entity.Comment;

/**
 * Created by MECHREVO on 2018/5/17.
 */

public class TeacherContentCommentLayout extends Fragment{
    private List<Comment> commentList = new ArrayList<Comment>();

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
        for(int i=0;i<10;i++){
            Comment courseView1=new Comment("1","马立新",1,"安卓开发");
           commentList.add(courseView1);
        }

    }
}

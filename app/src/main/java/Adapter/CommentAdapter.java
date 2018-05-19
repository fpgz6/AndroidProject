package Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidproject.R;

import java.util.List;

import Entity.Comment;

/**
 * Created by MECHREVO on 2018/5/19.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private List<Comment> mCommentList;
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView student_comment_name;
        TextView student_comment;
        TextView student_comment_mark;

        public ViewHolder(View view) {
            super(view);
            student_comment_name = (TextView) view.findViewById(R.id.comment_student_name);
            student_comment = (TextView) view.findViewById(R.id.comment_content);
            student_comment_mark = (TextView) view.findViewById(R.id.comment_mark);
        }
    }

    public CommentAdapter(List<Comment> mCommentList) {
        this.mCommentList = mCommentList;
    }

    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommentAdapter.ViewHolder holder, int position) {
        Comment comment = mCommentList.get(position);
        holder.student_comment_name.setText(comment.getStudent_name());
        holder.student_comment.setText(comment.getComment());
        holder.student_comment_mark.setText(comment.getMark());

    }

    @Override
    public int getItemCount() {
        return  mCommentList.size();
    }


}

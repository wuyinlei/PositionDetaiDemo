package com.mingchu.positiondetaidemo.attention.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mingchu.positiondetaidemo.R;
import com.mingchu.positiondetaidemo.attention.Comment;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by wuyinlei on 2017/3/11.
 */

public class CommentProAdapter extends ItemViewProvider<Comment,CommentProAdapter.ViewHolder>{

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.template_comment_second_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Comment comment) {
        holder.comment_content.setText(comment.getContent());  // TODO: 2017/3/11   等下更改
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView comment_content;

        public ViewHolder(View itemView) {
            super(itemView);

            comment_content = (TextView) itemView.findViewById(R.id.comment_content);
        }
    }
}

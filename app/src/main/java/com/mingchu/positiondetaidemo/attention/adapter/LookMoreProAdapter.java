package com.mingchu.positiondetaidemo.attention.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mingchu.positiondetaidemo.R;
import com.mingchu.positiondetaidemo.attention.LookMoreBean;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by wuyinlei on 2017/3/11.
 */

public class LookMoreProAdapter extends ItemViewProvider<LookMoreBean,LookMoreProAdapter.ViewHolder>{


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.look_more_item_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull final LookMoreBean lookMoreBean) {
        holder.look_more_content.setText("查看全部" + lookMoreBean.getConut() + "条评论");

        holder.look_more_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "点击了查看更多评论条目" + lookMoreBean.getConut(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView look_more_content;



        public ViewHolder(View itemView) {
            super(itemView);

            look_more_content = (TextView) itemView.findViewById(R.id.look_more_content);


        }
    }
}

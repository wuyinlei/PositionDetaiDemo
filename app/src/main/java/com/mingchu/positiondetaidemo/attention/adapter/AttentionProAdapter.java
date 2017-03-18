package com.mingchu.positiondetaidemo.attention.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mingchu.positiondetaidemo.CircleImageView;
import com.mingchu.positiondetaidemo.FoodImageActivity;
import com.mingchu.positiondetaidemo.R;
import com.mingchu.positiondetaidemo.ScreenUtil;
import com.mingchu.positiondetaidemo.Utils;
import com.mingchu.positiondetaidemo.attention.AttentionBean;
import com.mingchu.positiondetaidemo.emojitextview.EmojiTextView;
import com.mingchu.positiondetaidemo.image.ImageSize;
import com.mingchu.positiondetaidemo.widget.FeedGridView;
import com.mingchu.positiondetaidemo.widget.FeedPhotoModel;
import com.mingchu.positiondetaidemo.widget.MultiImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ItemViewProvider;

import static android.R.id.list;


public class AttentionProAdapter extends ItemViewProvider<AttentionBean, AttentionProAdapter.ViewHolder> {

    private ImageSize mSingleImageSize;

    private Context mContext;

    public AttentionProAdapter() {
    }

    public AttentionProAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hot_position_item_layout_attentioncopy_copy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull final ViewHolder holder, @NonNull final AttentionBean attentionBean) {
        Glide.with(holder.itemView.getContext())
                .load(attentionBean.getImgurl())
                .asBitmap().into(holder.userimage);

        holder.username.setText(attentionBean.getUsername());
        holder.user_post.setText(attentionBean.getPost());
        holder.company_place.setText(attentionBean.getCompany());

        String questionType = Utils.getStringQuestionType(attentionBean.getTypes());

        questionType = questionType + attentionBean.getContent();
        //微博
        Utils.fillWeiBoContent(questionType, holder.itemView.getContext(), holder.content);

        holder.publish_time.setText(attentionBean.getPublishtime());
        String commentcount = attentionBean.getCommentcount();
        if (commentcount.length() >= 4) {
            commentcount = "999+";
        }
        String zancount = attentionBean.getApprpvalcount();
        if (zancount.length() >= 4) {
            zancount = "999+";
        }


        holder.attention_comment.setText(commentcount);
        holder.attention_zan.setText(zancount);


        //NineGridView nineGrid = baseViewHolder.getView(R.id.nineGrid);
        //也就是用户发朋友圈的那种,添加图片
        final List<String> images = attentionBean.getImgUrls();
        if (images != null) {
            holder.nineGrid.setVisibility(View.VISIBLE);
        }

        holder.nineGrid.setPhotoAdapter(images);

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView userimage;
        private TextView username, company_place, user_post, publish_time, attention_zan, attention_comment;

        private RelativeLayout view_comment, view_zan;

        private Button bt_comment, bt_zan;

        private EmojiTextView content;
        //        private NineGridView nineGrid;
        private FeedGridView nineGrid;

        public ViewHolder(View itemView) {
            super(itemView);

            userimage = (CircleImageView) itemView.findViewById(R.id.iv_comment_head);
            username = (TextView) itemView.findViewById(R.id.tv_comment_person);
            company_place = (TextView) itemView.findViewById(R.id.tv_unit);
            user_post = (TextView) itemView.findViewById(R.id.tv_comment_company);

            content = (EmojiTextView) itemView.findViewById(R.id.detail_text);
//            nineGrid = (NineGridView) itemView.findViewById(R.id.nineGrid);

            nineGrid = (FeedGridView) itemView.findViewById(R.id.nineGrid);


            publish_time = (TextView) itemView.findViewById(R.id.tv_publish_time);
            //评论
            view_comment = (RelativeLayout) itemView.findViewById(R.id.view_comment);
            bt_comment = (Button) itemView.findViewById(R.id.bt_comment);
            attention_comment = (TextView) itemView.findViewById(R.id.tv_attention_comment);

            //点赞
            view_zan = (RelativeLayout) itemView.findViewById(R.id.view_zan);
            bt_zan = (Button) itemView.findViewById(R.id.bt_zan);
            attention_zan = (TextView) itemView.findViewById(R.id.tv_attention_zan_count);

        }
    }

    private onZanOnclickListener mOnZanOnclickListener;

    public void setOnZanOnclickListener(onZanOnclickListener onZanOnclickListener) {
        mOnZanOnclickListener = onZanOnclickListener;
    }

    interface onZanOnclickListener {

        void onItemClick(View v, int position, AttentionBean bean);
    }
}

package com.mingchu.positiondetaidemo.attention.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.mingchu.positiondetaidemo.CircleImageView;
import com.mingchu.positiondetaidemo.R;
import com.mingchu.positiondetaidemo.ZanUtils;
import com.mingchu.positiondetaidemo.attention.PublishBean;

import me.drakeet.multitype.ItemViewProvider;
import me.drakeet.multitype.MultiTypeAdapter;


public class FoodProAdapter extends ItemViewProvider<PublishBean, FoodProAdapter.ViewHolder> {

    private MultiTypeAdapter mMultiTypeAdapter;

    public FoodProAdapter(MultiTypeAdapter adapter) {
        this.mMultiTypeAdapter = adapter;
    }

    public FoodProAdapter() {
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attention_publish_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull final ViewHolder holder, @NonNull final PublishBean publishBean) {
        Glide.with(holder.itemView.getContext()).load(publishBean.getImgurl())
                .asBitmap().into(holder.userimage);

        Glide.with(holder.itemView.getContext()).load(publishBean.getProductimg())
                .asBitmap().into(holder.foodimage);

        holder.user_company.setText(publishBean.getCompany());
        holder.username.setText(publishBean.getUsername());
        holder.content.setText(publishBean.getContent());

        holder.food_name.setText(publishBean.getProductname());
        String commentcount = publishBean.getCommentcount();
        if (commentcount.length() >= 3) {
            commentcount = "99+";
        }
        String zancount = publishBean.getApprpvalcount();
//         int parseInt = Integer.parseInt(zancount);
        if (zancount.length() >= 3) {
            zancount = "99+";
        }
        holder.attention_comment.setText(commentcount);
        holder.attention_zan.setText(zancount);
        holder.publish_time.setText(publishBean.getPublishtime());
        holder.food_user_name.setText(publishBean.getUsername());

        holder.view_zan_animation.setVisibility(View.GONE); //防止错乱
        holder.tv_zan_past.setVisibility(View.GONE);  //防止错乱


        holder.bt_zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String parse="";

//                if (publishBean.getApprpvalcount().length()==3){
//                   parse =  publishBean.getApprpvalcount().substring(0,2);
//                } else {
//                    parse = publishBean.getApprpvalcount();
//                }

                int parseInt = Integer.parseInt(publishBean.getApprpvalcount());

//                publishBean.setApprpvalcount(parseInt + "");


                int fly = publishBean.getFly();

                publishBean.setFly(1);

                String hello = ZanUtils.clickZan(holder.itemView.getContext(), 1 + "", "hello", parseInt + "",
                        holder.bt_zan, holder.attention_zan, fly + "", holder.bt_zan_animation,
                        holder.tv_zan_past, holder.view_zan_animation);

//                String[] split = hello.split("-");
//
//                String c = split[1];

                parseInt=parseInt+1;

                publishBean.setApprpvalcount(parseInt+"");

                publishBean.setFly(1);
                publishBean.setFlag(1);


                mMultiTypeAdapter.notifyItemChanged(holder.getLayoutPosition());
//                holder.view_zan_animation.setVisibility(View.GONE);
            }
        });

        if (publishBean.getFlag() == 1) {
            holder.bt_zan.setBackgroundResource(R.mipmap.food_tab_good_copy);
            holder.bt_zan_animation.setBackgroundResource(R.mipmap.food_tab_good_copy);
        } else {
            holder.bt_zan.setBackgroundResource(R.mipmap.food_tab_good);
            holder.bt_zan_animation.setBackgroundResource(R.mipmap.food_tab_good);
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView userimage;
        private TextView username, user_company,
                content, food_name, publish_time,
                food_user_name, attention_zan, attention_zan_animation, attention_comment,tv_zan_past;
        private ImageView foodimage;

        private RelativeLayout view_comment, view_zan, view_zan_animation;

        private Button bt_comment, bt_zan;
        private Button bt_zan_animation;


        public ViewHolder(View itemView) {
            super(itemView);


            userimage = (CircleImageView) itemView.findViewById(R.id.iv_comment_head);
            username = (TextView) itemView.findViewById(R.id.tv_comment_person);
            user_company = (TextView) itemView.findViewById(R.id.tv_unit);

            content = (TextView) itemView.findViewById(R.id.detail_text);
            food_name = (TextView) itemView.findViewById(R.id.food_name);
            foodimage = (ImageView) itemView.findViewById(R.id.food_img);
            food_user_name = (TextView) itemView.findViewById(R.id.food_user_name);

            publish_time = (TextView) itemView.findViewById(R.id.tv_publish_time);
            //评论
            view_comment = (RelativeLayout) itemView.findViewById(R.id.view_comment);
            bt_comment = (Button) itemView.findViewById(R.id.bt_comment);
            attention_comment = (TextView) itemView.findViewById(R.id.tv_attention_comment);


            //点赞
            view_zan = (RelativeLayout) itemView.findViewById(R.id.view_zan);
            bt_zan = (Button) itemView.findViewById(R.id.bt_zan);
            attention_zan = (TextView) itemView.findViewById(R.id.tv_attention_zan_count);

            tv_zan_past = (TextView) itemView.findViewById(R.id.tv_zan_past);

            //点赞动画
            view_zan_animation = (RelativeLayout) itemView.findViewById(R.id.view_zan_animation);
            bt_zan_animation = (Button) itemView.findViewById(R.id.bt_zan_animation);
            attention_zan_animation = (TextView) itemView.findViewById(R.id.tv_attention_zan_count_animation);


//            view_zan.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(v.getContext(), "点击了点赞按钮  评论按钮逻辑差不多", Toast.LENGTH_SHORT).show();
//                    bt_zan.setBackgroundResource(R.mipmap.food_tab_good_copy);
//                    // TODO: 2017/3/11 点赞逻辑
//                }
//            });
        }
    }
}

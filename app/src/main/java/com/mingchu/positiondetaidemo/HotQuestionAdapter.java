package com.mingchu.positiondetaidemo;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mingchu.positiondetaidemo.emojitextview.EmojiTextView;
import com.mingchu.positiondetaidemo.image.FillContent;

import java.util.ArrayList;
import java.util.List;


public class HotQuestionAdapter extends RecyclerView.Adapter<HotQuestionAdapter.Viewholder> {


    private List<QuestionBean> mQuestionBeen = new ArrayList<>();


    public void setQuestionBeen(List<QuestionBean> questionBeen) {
        mQuestionBeen = questionBeen;
        notifyDataSetChanged();
    }

    public void loadMoreData(List<QuestionBean> questionBeen) {
        mQuestionBeen.addAll(questionBeen);
        notifyDataSetChanged();
    }


    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hot_position_item_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        Context context = holder.itemView.getContext();
        QuestionBean bean = mQuestionBeen.get(position);
        Glide.with(context).load(bean.getUserimgurl()).asBitmap().into(holder.iv_comment_head);
        holder.tv_comment_person.setText(bean.getUsername());
        holder.tv_comment_company.setText(bean.getUserplace());
        holder.tv_unit.setText(bean.getUsertype());
        String questiontype = Utils.getStringQuestionType(bean.getQuestiontype());
        String questioncontent = bean.getQuestioncontent();
        StringBuffer sb1 = new StringBuffer();
        sb1.append(questiontype);
        sb1.append(questioncontent);
//        SpannableString msp1 = new SpannableString(sb1.toString());
//        msp1.setSpan(new ForegroundColorSpan(
//                context.getResources().getColor(R.color.main_yellow)),0,
//                questiontype.length(),
//                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Utils.fillWeiBoContent(sb1.toString(),context,holder.detail_text);

//        holder.detail_text.setText(msp1);
        String commentUserName = bean.getCommentUser().getCommentusername();
        String commentUserComment = bean.getCommentUser().getCommentdetail();
        StringBuffer sb = new StringBuffer();
        sb.append(commentUserName);
        sb.append(" :");
        sb.append(commentUserComment);
        SpannableString msp = new SpannableString(sb.toString());

        //对评论者进行颜色配置
        msp.setSpan(new ForegroundColorSpan(Color.BLACK), 0,
                commentUserName.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        holder.comment_content.setText(msp);
        holder.look_more_content.setText("查看全部"+bean.getCommentcount()+"条数据");


        //NineGridView nineGrid = baseViewHolder.getView(R.id.nineGrid);
        //也就是用户发朋友圈的那种,添加图片
        List<String> images = bean.getImgurl();
        if (images != null) {
            holder.nineGrid.setVisibility(View.VISIBLE);
        }

        FillContent.fillWeiBoImgList(images, context, holder.nineGrid);


//        holder.nineGrid.setAdapter(new NineGridViewClickAdapter(context, imageInfo));
//
//        if (images != null && images.size() == 1) {
//            //如果用户只发了一张图片的话,就设置图片的宽和高
//            holder.nineGrid.setSingleImageSize(300);
//            holder.nineGrid.setSingleImageRatio(1);
//            //holder.mPhotoRecycler.setSingleImageRatio(images.get(0).width * 1.0f / images.get(0).height);
//        }

    }

    @Override
    public int getItemCount() {
        return mQuestionBeen.size() == 0 ? 0 : mQuestionBeen.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        EmojiTextView  detail_text;
        private CircleImageView iv_comment_head;
        private TextView tv_comment_person, tv_comment_company,
                tv_unit, comment_content, look_more_content;

//        private NineGridView nineGrid;

        private InputRecyclerView nineGrid;

        private Button bt_attention;

        public Viewholder(View item) {
            super(item);

            iv_comment_head = (CircleImageView) item.findViewById(R.id.iv_comment_head);
            tv_comment_company = (TextView) item.findViewById(R.id.tv_comment_company);
            tv_comment_person = (TextView) item.findViewById(R.id.tv_comment_person);
            tv_unit = (TextView) item.findViewById(R.id.tv_unit);
            detail_text = (EmojiTextView) item.findViewById(R.id.detail_text);
            comment_content = (TextView) item.findViewById(R.id.comment_content);
            look_more_content = (TextView) item.findViewById(R.id.look_more_content);
            nineGrid = (InputRecyclerView) item.findViewById(R.id.nineGrid);
            bt_attention = (Button) item.findViewById(R.id.bt_attention);

            bt_attention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "点击了查看关注评论", Toast.LENGTH_SHORT).show();
                }
            });

            look_more_content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "点击了查看更多评论", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

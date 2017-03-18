package com.mingchu.positiondetaidemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyinlei on 2017/3/10.
 */

public class NewQuestionAdapter extends RecyclerView.Adapter<NewQuestionAdapter.Viewholder> {

    private List<NewQuestionBean> mNewQuestionBeen = new ArrayList<>();

    public void setNewQuestionBeen(List<NewQuestionBean> newQuestionBeen) {
        mNewQuestionBeen = newQuestionBeen;
        notifyDataSetChanged();
    }

    public void loadMoreData(List<NewQuestionBean> newQuestionBeen){
        mNewQuestionBeen.addAll(newQuestionBeen);
        notifyDataSetChanged();
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_question_item_layout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        Context context = holder.itemView.getContext();
        NewQuestionBean bean = mNewQuestionBeen.get(position);
        String type = bean.getType();
        String content = bean.getContent();

        StringBuffer sb = new StringBuffer();
        sb.append(type);
        sb.append(" ");
        sb.append(content);

        SpannableString msp1 = new SpannableString(sb.toString());
        msp1.setSpan(new ForegroundColorSpan(
                        context.getResources().getColor(R.color.main_yellow)),0,
                type.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.question_content.setText(msp1);

        String attentionAndAnswer = context.getResources().getString(R.string.attention_and_answer);
        attentionAndAnswer = String.format(attentionAndAnswer,bean.getAttentioncount(),bean.getAnswercount());
        holder.attention_and_answer.setText(attentionAndAnswer);


    }

    @Override
    public int getItemCount() {
        return mNewQuestionBeen == null ? 0 : mNewQuestionBeen.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private TextView question_content,attention_and_answer;

        public Viewholder(View itemView) {
            super(itemView);

            question_content = (TextView) itemView.findViewById(R.id.question_content);
            attention_and_answer = (TextView) itemView.findViewById(R.id.attention_and_answer);
        }
    }
}

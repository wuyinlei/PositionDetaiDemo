package com.mingchu.positiondetaidemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class NewQuestionFragment extends Fragment {

    private RecyclerView normal_ask_recyclerview;
    private Button ask_release;

    private List<NewQuestionBean> mNewQuestionBeen = new ArrayList<>();


    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private NewQuestionAdapter mQuestionAdapter;

    public static NewQuestionFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        NewQuestionFragment pageFragment = new NewQuestionFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, null);

        initView(view);

        initData();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());

        normal_ask_recyclerview.setLayoutManager(manager);
        normal_ask_recyclerview.addItemDecoration(new SpaceItemDecoration(30));
        mQuestionAdapter = new NewQuestionAdapter();
        mQuestionAdapter.setNewQuestionBeen(mNewQuestionBeen);
        normal_ask_recyclerview.setAdapter(mQuestionAdapter);

        return view;
    }

    private void initData() {


        for (int i = 0; i < 20; i++) {
            NewQuestionBean bean = new NewQuestionBean();
            bean.setType("#名厨回答");
            bean.setUsername("中华小当家");
            bean.setAttentioncount(i*32+"");
            bean.setAnswercount(i*10+"");
            bean.setContent("当然上述的推理结果是默认每个Item的spanSize的大小都为1为前提条件进行的，所以为了公式更加通用，下面我们具体讨论当spanSize大小不固定的情况");
            mNewQuestionBeen.add(bean);
        }

    }


    private void initView(View view) {

        normal_ask_recyclerview = (RecyclerView) view.findViewById(R.id.recycler_view);
        ask_release = (Button) view.findViewById(R.id.ask_release);

    }
}

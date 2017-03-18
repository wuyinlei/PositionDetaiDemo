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


public class HotQuestionFragment extends Fragment {

    private RecyclerView normal_ask_recyclerview;
    private Button ask_release;

    private List<QuestionBean> mQuestionBeen = new ArrayList<>();


    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private HotQuestionAdapter mAdapter;

    public static HotQuestionFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        HotQuestionFragment hotQuestionFragment = new HotQuestionFragment();
        hotQuestionFragment.setArguments(args);
        return hotQuestionFragment;
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
        normal_ask_recyclerview.addItemDecoration(new SpaceItemDecoration(20));
        mAdapter = new HotQuestionAdapter();
        mAdapter.setQuestionBeen(mQuestionBeen);
        normal_ask_recyclerview.setAdapter(mAdapter);

        return view;
    }

    private void initData() {
        List<String> imgurls = new ArrayList<>();
        String url = null;
        String[] strings = new String[]{"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_5.png",
                "http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_29.png",
                "http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_2.png",
                "http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_31.png",
                "http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_37.png",
                "http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_14.png"
                , "http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_28.png",
                "http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_28.png"};


        for (int i = 0; i < 3; i++) {
            QuestionBean bean = new QuestionBean();
            bean.setUserimgurl("http://image.xinliji.me/FuNz0wgfkHfpLdwPpon_T9wiiSeB");

            bean.setCommentcount(1000 * i);
            bean.setUsername("菜鸟一枚你晓得");
//            int j = i / 15;
//            for (int k = 0; k < 1; k++) {
//                imgurls.add(strings[k]);
//
//            }
            imgurls.add("http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_37.png");
//            imgurls.add("http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_14.png");


            bean.setImgurl(imgurls);

            List<String> type = new ArrayList<>();
            type.add("名厨解答" + i);
            type.add("大师几倍");

            bean.setUsertype("无名小站咖啡店");

            bean.setQuestiontype(type);

            bean.setUserplace("北京香格里拉大酒店" + i);
            QuestionBean.CommentUser commentUser = new QuestionBean.CommentUser();
            commentUser.setCommentdetail("早年父亲欠账出去躲债，母亲独自面对前来讨债的人（其中还有父亲的亲哥哥），心里留下了很深的伤痕。后来，家中有持续稳定收入的只有母亲，父亲打零工，慢慢家中日子也好过了。但由于他们之间一直有这个疙瘩，导致常常因为琐事争吵，母亲总看不惯父亲的行事，父亲总觉得冤枉，嫌母亲唠叨。在我看来，母亲一方面确实放不下以前的心结，" +
                    "一方面由于原生家庭的原因性格确实很情绪化；父亲做事太过粗线条，不太考虑他人的感受");
            commentUser.setCommentusername("名厨集团");

            bean.setCommentUser(commentUser);


            bean.setQuestioncontent("如果给一个品牌写一句广告标语，" +
                    "难在何处呢？ 难就难在，如果你写出来的这句话是完美的，" +
                    "那么它就缺乏记忆点；如果你写出来的这句话不完美，那它在初期很难被人接受。 有一些我们耳熟能");


            mQuestionBeen.add(bean);
        }
    }

    private void initView(View view) {

        normal_ask_recyclerview = (RecyclerView) view.findViewById(R.id.recycler_view);
        ask_release = (Button) view.findViewById(R.id.ask_release);

    }
}

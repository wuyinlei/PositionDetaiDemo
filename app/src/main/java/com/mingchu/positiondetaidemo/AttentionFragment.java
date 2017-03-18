package com.mingchu.positiondetaidemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mingchu.positiondetaidemo.attention.AttentionBean;
import com.mingchu.positiondetaidemo.attention.Comment;
import com.mingchu.positiondetaidemo.attention.LookMoreBean;
import com.mingchu.positiondetaidemo.attention.PublishBean;
import com.mingchu.positiondetaidemo.attention.adapter.AttentionProAdapter;
import com.mingchu.positiondetaidemo.attention.adapter.CommentProAdapter;
import com.mingchu.positiondetaidemo.attention.adapter.FoodProAdapter;
import com.mingchu.positiondetaidemo.attention.adapter.LookMoreProAdapter;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;


import static me.drakeet.multitype.MultiTypeAsserts.assertAllRegistered;

public class AttentionFragment extends Fragment {


    private RecyclerView mRecyclerView;
    MultiTypeAdapter adapter;


    Items items = new Items();

    Items originItems = new Items();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attention, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();


        adapter.register(AttentionBean.class, new AttentionProAdapter(getActivity()));
        adapter.register(Comment.class, new CommentProAdapter());

        adapter.register(LookMoreBean.class, new LookMoreProAdapter());

        adapter.register(PublishBean.class, new FoodProAdapter(adapter));


        loadData();
        adapter.setItems(originItems);
        adapter.notifyDataSetChanged();

        assertAllRegistered(adapter, originItems);
        mRecyclerView.setAdapter(adapter);
    }

    private void loadData() {

        for (int i = 0; i < 20; i++) {
            if (i % 4 == 0) {
                //模拟发表菜品数据
                PublishBean bean = new PublishBean();
                bean.setContent("发布了一道新菜品,大家快来看啊~~~~~");
                bean.setUsername("刘二中" + i);
                bean.setApprpvalcount(90 * i + "");
                bean.setCommentcount(38 * i + "");
                bean.setImgurl("http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_29.png");
                bean.setProductimg("http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_28.png");
                bean.setCompany("南京中南理工厨师");
                bean.setPublishtime("两个小时前");
                bean.setProductname("两只小蜜蜂啊" + i);
                originItems.add(bean);
            } else {
                //模拟关注人数据
                AttentionBean bean = new AttentionBean();
                bean.setImgurl("http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_37.png");
                bean.setUsername("甜点大师傅" + i);
                bean.setPost("甜点师傅");
                bean.setCompany("第二中学中堂师傅" + i);

                List<String> strings = new ArrayList<>();
                //模拟type类型
                int k = 0, j = 0;
                if (i / 2 == 0) {
                    k = 1;
                    j = 4;
                } else {
                    k = 3;
                    j = 1;
                }
                for (int i1 = 0; i1 < k; i1++) {
                    strings.add("名厨大课堂" + i);
                }
                bean.setTypes(strings);
                bean.setContent("新研发了仙人掌马卡龙蛋糕，需要不需要尝一下爱呢，~~~~");

                List<String> urls = new ArrayList<>();
                for (int i2 = 0; i2 < j; i2++) {
                    urls.add("http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_m_3.png");
//                    urls.add("http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_31.png");
                }
                bean.setImgUrls(urls);

                bean.setPublishtime("三个小时前");
                bean.setApprpvalcount(90 * i + "");
                bean.setCommentcount(38 * i + "");
                bean.setCommentcount(43 * i + "");

                Comment comment = new Comment();
                List<Comment> comments = new ArrayList<>();

                for (int i3 = 0; i3 < k; i3++) {
                    comment.setContent("哇塞，这个这么好吃啊，我也要自己做着吃");
                    comment.setByreviewsuser("大师级别");
                    comment.setCommentuser("小弟弟级别的" + i3);
                    comments.add(comment);
                }

                LookMoreBean moreBean = new LookMoreBean();
                moreBean.setConut(56 * i + "");

                //bean.setComments(comments);
                originItems.add(bean);
                for (Comment comment1 : comments) {
                    originItems.add(comment1);
                }
//                originItems.addAll(comments);
                originItems.add(moreBean);
            }
        }


    }

}

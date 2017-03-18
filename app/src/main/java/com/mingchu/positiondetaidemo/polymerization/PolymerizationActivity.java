package com.mingchu.positiondetaidemo.polymerization;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mingchu.positiondetaidemo.CircleImageView;
import com.mingchu.positiondetaidemo.MyApp;
import com.mingchu.positiondetaidemo.ObservableScrollView;
import com.mingchu.positiondetaidemo.R;
import com.mingchu.positiondetaidemo.ScrollViewListener;
import com.mingchu.positiondetaidemo.Utils;
import com.mingchu.positiondetaidemo.attention.AttentionBean;
import com.mingchu.positiondetaidemo.attention.Comment;
import com.mingchu.positiondetaidemo.attention.LookMoreBean;
import com.mingchu.positiondetaidemo.attention.PublishBean;
import com.mingchu.positiondetaidemo.attention.adapter.AttentionProAdapter;
import com.mingchu.positiondetaidemo.attention.adapter.CommentProAdapter;
import com.mingchu.positiondetaidemo.attention.adapter.FoodProAdapter;
import com.mingchu.positiondetaidemo.attention.adapter.LookMoreProAdapter;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

import static me.drakeet.multitype.MultiTypeAsserts.assertAllRegistered;


public class PolymerizationActivity extends AppCompatActivity implements ScrollViewListener {
    private RelativeLayout headerViewContent;
    private ImageView overlay; //上部header
    private RelativeLayout headerDetail; //上部header信息

    private RecyclerView recyclerView;

    private ObservableScrollView scrollView;

    private ImageView topic_close, topic_share;

    private TextView topic_title_text, topic_content_text;

    private RelativeLayout re_image; //用于三张图片是否显示
    private View view_rv_iv1, view_rv_iv2, view_rv_iv3;
    private CircleImageView rv_iv1, rv_iv2, rv_iv3;
    private TextView topic_people_count;

    private RelativeLayout bottom_container;  //底部按钮

    private Toolbar mToolbar;


    MultiTypeAdapter adapter;


    Items items = new Items();

    Items originItems = new Items();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        setContentView(R.layout.polymerization_topic_layout);

        initView();


        setUpEverything();

    }

    private ActionBar actionBar;

    private void setUpEverything() {

        setSupportActionBar(mToolbar);
        actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(R.drawable.actionbar_back);
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setTitle("歌单");
//        mToolbar.setPadding(0, mStatusSize, 0, 0);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//

        setHeaderView();
        setList();
        loadAllLists();
    }

    private void loadAllLists() {


    }

    private void setList() {

        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();
        adapter.register(AttentionBean.class, new AttentionProAdapter(this));
        adapter.register(Comment.class, new CommentProAdapter());
        adapter.register(LookMoreBean.class, new LookMoreProAdapter());
//        adapter.register(LookMoreBean.class, new FoodProAdapter());

        loadData();

        adapter.setItems(originItems);
        adapter.notifyDataSetChanged();

        assertAllRegistered(adapter, originItems);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        recyclerView.setScrollViewCallbacks(this);
        LinearLayoutManager layout = new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(layout);
        recyclerView.setHasFixedSize(true);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setAdapter(adapter);
//        mRecyclerView.setAdapter(adapter);


    }

    private void loadData() {

        for (int i = 1; i < 20; i++) {
            if (i % 21 == 0) {
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
                bean.setContent("新研发了仙人#掌马卡龙,蛋糕，需要不需要尝一下爱呢，~~~~");

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
                    comment.setContent("哇塞，这个这么好吃啊，我也要自己做着吃这个这么好吃啊，我也要自己做着吃这个这么好吃啊，我也要自己做着吃这个这么好吃啊，我也要自己做着吃");
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

    private void setHeaderView() {


    }

    private RelativeLayout re_toolbar;

    private void initView() {
        overlay = (ImageView) findViewById(R.id.overlay);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        topic_close = (ImageView) findViewById(R.id.topic_close);
        topic_share = (ImageView) findViewById(R.id.topic_share);
        topic_title_text = (TextView) findViewById(R.id.topic_title_text);
        topic_content_text = (TextView) findViewById(R.id.topic_content_text);

        headerViewContent = (RelativeLayout) findViewById(R.id.headerview);
//        headerDetail = (RelativeLayout) findViewById(R.id.headerview);

        re_image = (RelativeLayout) findViewById(R.id.re_image);
        view_rv_iv1 = findViewById(R.id.view_rv_iv1);
        view_rv_iv2 = findViewById(R.id.view_rv_iv2);
        view_rv_iv3 = findViewById(R.id.view_rv_iv3);

        rv_iv1 = (CircleImageView) findViewById(R.id.rv_iv1);
        rv_iv2 = (CircleImageView) findViewById(R.id.rv_iv2);
        rv_iv3 = (CircleImageView) findViewById(R.id.rv_iv3);

        topic_people_count = (TextView) findViewById(R.id.topic_people_count);

        bottom_container = (RelativeLayout) findViewById(R.id.bottom_container);


        mActionBarSize = Utils.getActionBarHeight(this);
        mStatusSize = Utils.getStatusHeight(this);
        mFlexibleSpaceImageHeight = getResources().getDimensionPixelSize(R.dimen.flexible_space_image_height);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);


        scrollView = (ObservableScrollView) findViewById(R.id.scrollView);

        scrollView.smoothScrollBy(0,0);

        scrollView.setScrollViewListener(this);

        re_toolbar = (RelativeLayout) findViewById(R.id.re_toolbar);


    }


    protected void updateViews(int scrollY, boolean animated) {
        // If it's ListView, onScrollChanged is called before ListView is laid out (onGlobalLayout).
        // This causes weird animation when onRestoreInstanceState occurred,
        // so we check if it's laid out already.
//        if (!mReady) {
//            return;
//        }

        // Translate header
        ViewHelper.setTranslationY(headerViewContent, getHeaderTranslationY(scrollY));

    }

    private int mActionBarSize;
    private int mStatusSize;
    private int mFlexibleSpaceImageHeight;

    protected float getHeaderTranslationY(int scrollY) {
        final int headerHeight = headerViewContent.getHeight();
        int headerTranslationY = mActionBarSize + mStatusSize - headerHeight;
        if (mActionBarSize + mStatusSize <= -scrollY + headerHeight) {
            headerTranslationY = -scrollY;
        }
        return headerTranslationY;
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        int scrollY = scrollView.getScrollY();
        float v = (float) scrollY / MyApp.dip2px(313);
        re_toolbar.setAlpha(v);
    }


//    @Override
//    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
//        updateViews(scrollY, false);
//
//        if (scrollY > 0 && scrollY < mFlexibleSpaceImageHeight - mActionBarSize - mStatusSize) {
////            toolbar.setTitle(playlistName);
////            toolbar.setSubtitle(playlistDetail);
////            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbar_background));
//        }
//        if (scrollY == 0) {
////            toolbar.setTitle("歌单");
////            actionBar.setBackgroundDrawable(null);
//        }
//        if (scrollY > mFlexibleSpaceImageHeight - mActionBarSize - mStatusSize) {
//
////            if(mBlurDrawable != null){
////                mBlurDrawable.setColorFilter(Color.parseColor("#79000000"), PorterDuff.Mode.SRC_OVER);
////                actionBar.setBackgroundDrawable(mBlurDrawable);
////            }
//        }
//
//        float a = (float) scrollY / (mFlexibleSpaceImageHeight - mActionBarSize - mStatusSize);
////        headerDetail.setAlpha(1f - a);
//    }
//
//    @Override
//    public void onDownMotionEvent() {
//
//    }
//
//    @Override
//    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
//
//    }

}

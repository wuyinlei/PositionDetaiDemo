//package com.mingchu.positiondetaidemo;
//
//import android.annotation.TargetApi;
//import android.graphics.Color;
//import android.media.Image;
//import android.os.Build;
//import android.support.design.widget.AppBarLayout;
//import android.support.design.widget.CollapsingToolbarLayout;
//import android.support.design.widget.CoordinatorLayout;
//import android.support.design.widget.TabLayout;
//import android.support.v4.app.Fragment;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.jaeger.library.StatusBarUtil;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    private LinearLayout head_layout;
//    private TabLayout toolbar_tab;
//    private ViewPager main_vp_container;
//    private CollapsingToolbarLayout mCollapsingToolbarLayout;
//    private CoordinatorLayout root_layout;
//    AppBarLayout app_bar_layout;
//
//    private TextView title_text; //标题
//    private TextView content_text;  //标题简介
//
//    private TextView title_bar;
//
//    private CircleImageView rv_iv1,rv_iv2,rv_iv3;
//
//    private ImageView img_back,img_share;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        initView();
//
//        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//        //设置折叠的时候标题显示字体颜色
//        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
//        app_bar_layout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (verticalOffset <= -head_layout.getHeight() / 2) {
//                    title_bar.setText("名厨问答");
//                } else {
//                    title_bar.setText(" ");
//                }
//            }
//        });
//        List<Fragment> fragments = new ArrayList<>();
//        fragments.add(HotQuestionFragment.newInstance(1));
//        fragments.add(NewQuestionFragment.newInstance(3));
//
//        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
//        main_vp_container.setAdapter(vpAdapter);
//        main_vp_container.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener
//                (toolbar_tab));
//        toolbar_tab.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener
//                (main_vp_container));
//        //tablayout和viewpager建立联系为什么不用下面这个方法呢？自己去研究一下，可能收获更多
//        //toolbar_tab.setupWithViewPager(main_vp_container);
//        loadBlurAndSetStatusBar();
//
//    }
//
//    private void initView() {
//        app_bar_layout = (AppBarLayout) findViewById(R.id.app_bar_layout);
//
//        head_layout = (LinearLayout) findViewById(R.id.head_layout);
//        root_layout = (CoordinatorLayout) findViewById(R.id.root_layout);
//        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
//        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id
//                .collapsing_toolbar_layout);
//
//        toolbar_tab = (TabLayout) findViewById(R.id.toolbar_tab);
//        main_vp_container = (ViewPager) findViewById(R.id.main_vp_container);
//
//        title_text= (TextView) findViewById(R.id.title_text);
//        content_text = (TextView) findViewById(R.id.content_text);
//        title_bar = (TextView) findViewById(R.id.title_bar);
//
//        rv_iv1 = (CircleImageView) findViewById(R.id.rv_iv1);
//
//        Glide.with(this).load("http://image.xinliji.me//Fs9V_0a-ZIY-DSNErnmlSnRW8R_9").asBitmap().into(rv_iv1);
//        rv_iv2 = (CircleImageView) findViewById(R.id.rv_iv2);
//        Glide.with(this).load("http://image.xinliji.me//FnHy1UAnV2r85y3y2aHKpMx4Ik5C").asBitmap().into(rv_iv2);
//
//        rv_iv3 = (CircleImageView) findViewById(R.id.rv_iv3);
//        Glide.with(this).load("http://image.xinliji.me//FhJvclNjNphLq9hPTUTKm9kPGb44").asBitmap().into(rv_iv3);
//
//
////        img_back = (ImageView) findViewById(R.id.live_close);
////        img_share = (ImageView) findViewById(R.id.live_share);
//
//    }
//
//    /**
//     * 设置毛玻璃效果和沉浸状态栏
//     */
//    private void loadBlurAndSetStatusBar() {
//        StatusBarUtil.setTranslucent(MainActivity.this, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
//
//    }
//}

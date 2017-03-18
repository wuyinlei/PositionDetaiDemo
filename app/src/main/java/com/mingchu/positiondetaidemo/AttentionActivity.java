package com.mingchu.positiondetaidemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;

import com.mingchu.positiondetaidemo.spannablestream.SpannableStream;

import java.util.ArrayList;
import java.util.List;

public class AttentionActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new AttentionFragment());
        fragments.add(new AttentionFragment());

        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(vpAdapter);
        mTabLayout.setupWithViewPager(mViewPager);


//        SpannableStream.with(this)
//                .

    }
}

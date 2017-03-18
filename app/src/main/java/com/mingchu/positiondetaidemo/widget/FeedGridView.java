package com.mingchu.positiondetaidemo.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;


import com.mingchu.positiondetaidemo.R;
import com.mingchu.positiondetaidemo.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

public class FeedGridView extends BaseGridView implements AdapterView.OnItemClickListener {

    private static final String TAG = "FeedGridView";

    private List<String> mDatas = new ArrayList<>();

    private int mHorizontalSpacing, mVerticalSpacing, mPaddingSpacing,mMarginSpacing;

    public FeedGridView(Context context) {
        super(context);
    }

    public FeedGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = getContext().obtainStyledAttributes(attrs,
                R.styleable.FeedGridView);
        mHorizontalSpacing = array.getDimensionPixelSize(R.styleable.FeedGridView_hSpacing, 0);
        mVerticalSpacing = array.getDimensionPixelSize(R.styleable.FeedGridView_vSpacing, 0);
        mPaddingSpacing = array.getDimensionPixelSize(R.styleable.FeedGridView_pSpacing, 0);
        mMarginSpacing = array.getDimensionPixelSize(R.styleable.FeedGridView_mSpacing,0);
        array.recycle();
    }

    public FeedGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private FeedPhotoAdapter photoAdapter;
    private int mColumnNum;

    public void setPhotoAdapter(List<String> imgs) {
        mDatas.clear();
        mDatas.addAll(imgs);
        int count = mDatas.size();
        //一张图片的时候也是占1/2
        if (count == 1) {
            mColumnNum = 1;
            setNumColumns(1);
        } else if (count == 2 || count == 4) {
            mColumnNum = 2;
            setNumColumns(2);
        } else {
            mColumnNum = 3;
            setNumColumns(3);
        }
        Log.d("zhe", "mHorizontalSpacing:" + mHorizontalSpacing);
        Log.d("zhe", "mVerticalSpacing:" + mVerticalSpacing);
        setHorizontalSpacing(mHorizontalSpacing);
        setVerticalSpacing(mVerticalSpacing);
        int width = calculateColumnWidth();
        setColumnWidth(width);
        photoAdapter = new FeedPhotoAdapter((Activity) getContext(), mDatas, width);
        this.setAdapter(photoAdapter);
        this.setOnItemClickListener(this);
        photoAdapter.notifyDataSetChanged();
        setGridViewWidthBasedOnChildren(this, mDatas.size());
    }

    private int calculateColumnWidth() {
        int width = ScreenUtil.getScreenWidth((Activity) getContext());
        if (mColumnNum == 1) {
            width = (width - mPaddingSpacing - mHorizontalSpacing - mMarginSpacing);
        } else if (mColumnNum == 2) {
            width = (width - mPaddingSpacing * 2 - mHorizontalSpacing - mMarginSpacing) / mColumnNum;
        } else if (mColumnNum == 3) {
            width = (width - mPaddingSpacing * 2 - mHorizontalSpacing * 2 - mMarginSpacing) / mColumnNum;
        }
        return width;
    }

    /**
     * 动态计算gridview的宽度
     *
     * @param gridView
     * @param count
     */
    public void setGridViewWidthBasedOnChildren(GridView gridView, int count) {
        // 获取gridview的adapter
        ListAdapter listAdapter = gridView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        // 固定列宽，有多少列
        int col = count;
        if (listAdapter.getCount() < count) {
            col = listAdapter.getCount();
        }
        if (count == 4) {
            col = 2;
        }
        int totalWidth = 0;
        for (int i = 0; i < col; i++) {
            // 获取gridview的每一个item
            View listItem = listAdapter.getView(i, null, gridView);
            listItem.measure(0, 0);
            // 获取item的宽度和
            totalWidth += listItem.getMeasuredWidth() + mHorizontalSpacing * 2;
        }
        // 获取gridview的布局参数
        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        // 设置宽度
        params.width = totalWidth;
        // 设置参数
        gridView.setLayoutParams(params);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), "position:" + position, Toast.LENGTH_SHORT).show();
    }
}

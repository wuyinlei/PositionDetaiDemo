package com.mingchu.positiondetaidemo.image;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mingchu.positiondetaidemo.R;
import com.mingchu.positiondetaidemo.ScreenUtil;

import java.util.ArrayList;
import java.util.List;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<String> mData;
    private Context mContext;

    private final ImageSize mSingleImageSize;
    private final ImageSize mDoubleImgSize;
    private final ImageSize mThreeImgSize;

    public ImageAdapter(List<String> lists, Context context) {
//        this.mStatus = status;
        this.mData = lists;
        this.mContext = context;
        mSingleImageSize = new ImageSize(ScreenUtil.getScreenWidth(context), (int) (ScreenUtil.getScreenWidth(context) * 0.7));
        mDoubleImgSize = new ImageSize(ScreenUtil.getScreenWidth(context) / 2, ScreenUtil.getScreenWidth(context) / 2);
        mThreeImgSize = new ImageSize(ScreenUtil.getScreenWidth(context) / 3,ScreenUtil.getScreenWidth(context) / 3);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.mainfragment_weiboitem_imageitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        //设置加载中的图片样式
        setImgSize(mData, mContext, viewHolder.norImg);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        FillContent.fillImageList(mContext,
                mData,
                position,
                holder.norImg,
                mSingleImageSize,
                mDoubleImgSize,
                mThreeImgSize);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setData(List<String> data) {
        this.mData = data;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public SubsamplingScaleImageView longImg;
        public ImageView norImg;
//        public GifImageView gifImg;
//        public ImageView imageLabel;

        public ViewHolder(View itemView) {
            super(itemView);
            norImg = (ImageView) itemView.findViewById(R.id.norImg);
        }
    }

    /**
     * 根据图片的数量，设置不同的尺寸
     *
     * @param datas
     * @param context
     * @param norImg
     */
    private static void setImgSize(List<String> datas, Context context, ImageView norImg) {
        if (datas == null || datas.size() == 0) {
            return;
        }
        if (datas.size() == 1) {
            setSingleImgSize(context, norImg);
        } else if (datas.size() == 2 || datas.size() == 4) {
            setDoubleImgSize(context, norImg);
        } else if (datas.size() == 3 || datas.size() >= 5) {
            setThreeImgSize(context, norImg);
        }
    }

    private static void setDoubleImgSize(Context context, ImageView norImg) {
        FrameLayout.LayoutParams norImgLayout = (FrameLayout.LayoutParams) norImg.getLayoutParams();
        norImgLayout.width = ScreenUtil.getScreenWidth(context) / 2;
        norImgLayout.height = ScreenUtil.getScreenWidth(context) / 2;
    }

    private static void setSingleImgSize(Context context, ImageView norImg) {
        FrameLayout.LayoutParams norImgLayout = (FrameLayout.LayoutParams) norImg.getLayoutParams();
        norImgLayout.width = ScreenUtil.getScreenWidth(context);
        norImgLayout.height = (int) (ScreenUtil.getScreenWidth(context) * 0.7);
    }

    private static void setThreeImgSize(Context context, ImageView norImg) {
        FrameLayout.LayoutParams norImgLayout = (FrameLayout.LayoutParams) norImg.getLayoutParams();
        norImgLayout.width = ScreenUtil.getScreenWidth(context) / 3;
        norImgLayout.height = ScreenUtil.getScreenWidth(context) / 3;
    }

}


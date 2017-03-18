package com.mingchu.positiondetaidemo.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mingchu.positiondetaidemo.InputRecyclerView;
import com.mingchu.positiondetaidemo.imageloader.BitmapLoadingListener;
import com.mingchu.positiondetaidemo.imageloader.ImageLoader;

import java.util.List;


public class FillContent {


    /**
     * @param context
     * @param position
     * @param norImg
     * @param mSingleImageSize
     * @param mDoubleImgSize
     * @param mThreeImgSize
     */
    public static void fillImageList(final Context context,
                                     final List<String> list,
                                     final int position,
                                     final ImageView norImg,
                                     ImageSize mSingleImageSize,
                                     ImageSize mDoubleImgSize,
                                     ImageSize mThreeImgSize) {
        final List<String> urllist = list;
        if (urllist.size() == 1) {

            ImageLoader.loadBitmap(context,mSingleImageSize, urllist.get(position), new BitmapLoadingListener() {
                @Override
                public void onSuccess(Bitmap b) {
                    norImg.setVisibility(View.VISIBLE);
                    displayNorImg( b, norImg);
                }

                @Override
                public void onError() {

                }
            });

//                    ImageLoader.loadImage(urllist.get(position), mSingleImageSize, options, new SimpleImageLoadingListener() {
//                @Override
//                public void onLoadingStarted(String s, View view) {
//                    setLabelForGif(urllist.get(position), imageLabel);
//                }
//
//                @Override
//                public void onLoadingComplete(String imageUri, View view, Bitmap bitmap) {
//                        norImg.setVisibility(View.VISIBLE);
//                        displayNorImg( bitmap, norImg);
//                }
//            });
        } else if (urllist.size() == 2 || urllist.size() == 4) {

            ImageLoader.loadBitmap(context,mDoubleImgSize, urllist.get(position), new BitmapLoadingListener() {
                @Override
                public void onSuccess(Bitmap b) {
                    norImg.setVisibility(View.VISIBLE);
                    displayNorImg(b, norImg);
                }

                @Override
                public void onError() {

                }
            });
        } else if (urllist.size() == 3 || urllist.size() >= 5) {

            ImageLoader.loadBitmap(context, mThreeImgSize,urllist.get(position), new BitmapLoadingListener() {
                @Override
                public void onSuccess(Bitmap b) {
                    norImg.setVisibility(View.VISIBLE);
                    displayNorImg(b, norImg);
                }

                @Override
                public void onError() {

                }
            });

        } else {

            ImageLoader.loadBitmap(context, null,urllist.get(position), new BitmapLoadingListener() {
                @Override
                public void onSuccess(Bitmap b) {
                    norImg.setVisibility(View.VISIBLE);
                    displayNorImg(b, norImg);
                }

                @Override
                public void onError() {

                }
            });

        }


        norImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击我了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void fillWeiBoImgList(List<String> imglists, Context context, InputRecyclerView recyclerview) {
        if (imglists == null || imglists.size() == 0) {
            recyclerview.setVisibility(View.GONE);
            return;
        }
        if (recyclerview.getVisibility() == View.GONE) {
            recyclerview.setVisibility(View.VISIBLE);
        }
        GridLayoutManager gridLayoutManager = initGridLayoutManager(imglists, context);
        ImageAdapter imageAdapter = new ImageAdapter(imglists, context);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(imageAdapter);
        recyclerview.setLayoutManager(gridLayoutManager);
        imageAdapter.setData(imglists);
        imageAdapter.notifyDataSetChanged();
    }


    public static void displayNorImg(Bitmap bitmap, ImageView norImg) {
        norImg.setImageBitmap(bitmap);
        norImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }


    /**
     * 根据图片数量，初始化GridLayoutManager，并且设置列数，
     * 当图片 = 1 的时候，显示1列
     * 当图片<=4张的时候，显示2列
     * 当图片>4 张的时候，显示3列
     *
     * @return
     */
    private static GridLayoutManager initGridLayoutManager(List<String> imageDatas, Context context) {
        GridLayoutManager gridLayoutManager;
        if (imageDatas != null) {
            switch (imageDatas.size()) {
                case 1:
                    gridLayoutManager = new GridLayoutManager(context, 1);
                    break;
                case 2:
                    gridLayoutManager = new GridLayoutManager(context, 2);
                    break;
                case 3:
                    gridLayoutManager = new GridLayoutManager(context, 3);
                    break;
                case 4:
                    gridLayoutManager = new GridLayoutManager(context, 2);
                    break;
                default:
                    gridLayoutManager = new GridLayoutManager(context, 3);
                    break;
            }
        } else {
            gridLayoutManager = new GridLayoutManager(context, 3);
        }
        return gridLayoutManager;
    }

}

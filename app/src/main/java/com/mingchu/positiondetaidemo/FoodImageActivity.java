package com.mingchu.positiondetaidemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


public class FoodImageActivity extends AppCompatActivity {
    private ViewPager vp_food_image;
    private ArrayList<String> piclist;
    private ImageView iv_image;
    private ImageView iv_circle_goback;
    Bitmap bm;

    private Button bt_down;
    private File imgfile;
    private TextView tv_number;
    private String position;
    private ArrayList<Bitmap> piclistBitmap = new ArrayList<Bitmap>();
    //在消息队列中实现对控件的更改
    private Handler handle = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    vp_food_image.setAdapter(new FoodDetailtAdapter());
                    try {
                        //  vp_food_image.setAdapter(new FoodDetailtAdapter());
                        vp_food_image.setCurrentItem(Integer.parseInt(position));
                        tv_number.setText(Integer.parseInt(position) + 1 + "/" + piclist.size());
                    } catch (Exception e) {

                    }
                    break;
            }
        }

        ;
    };
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_image);
        position = getIntent().getStringExtra("position");
        name = getIntent().getStringExtra("name");
        vp_food_image = (ViewPager) findViewById(R.id.vp_food_image);
        tv_number = (TextView) findViewById(R.id.tv_number);

        iv_circle_goback = (ImageView) findViewById(R.id.iv_circle_goback);
        bt_down = (Button) findViewById(R.id.bt_down);
        //接受页面传递过来的数据
        piclist = (ArrayList<String>) this.getIntent().getSerializableExtra("piclist");

        iv_circle_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        vp_food_image.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_number.setText(position + 1 + "/" + piclist.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp_food_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //下载网络图片

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Aut
                for (int i = 0; i < piclist.size(); i++) {
                    Bitmap bmp = StreamTools.getURLimage(piclist.get(i));
                    if (!TextUtils.isEmpty(name)) {
                        Bitmap waterMaskImage = WaterMaskImage.createWaterMaskImage(FoodImageActivity.this, bmp, BitmapFactory.decodeResource(getResources(), R.mipmap.mingchuseal), name);
                        piclistBitmap.add(waterMaskImage);
                    } else {
                        piclistBitmap.add(bmp);
                    }

                }
                Message msg = new Message();
                msg.what = 0;
//                msg.obj = bmp;
                System.out.println("000");
                handle.sendMessage(msg);

            }
        }).start();


    }


    class FoodDetailtAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return piclist.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            container.removeView((View) object);
        }

        // 显示布局
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            // TODO Auto-generated method stub
            View v = LayoutInflater.from(FoodImageActivity.this).inflate(R.layout.photoprelayout, null);
            PhotoView photoView = (PhotoView) v.findViewById(R.id.photo_pre);
            photoView.setScaleLevels(1.0f, 1.25f, 1.5f);
            photoView.setImageBitmap(piclistBitmap.get(position));

            photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    finish();
                }

                @Override
                public void onOutsidePhotoTap() {
                    finish();
                }
            });

            container.addView(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            return v;
//            final PhotoView photoView = new PhotoView(container.getContext());
//            //   MyApp.imageXutils.display(photoView, piclist.get(posi.foodurl_photo);
//            photoView.setScaleLevels(1.0f, 1.25f, 1.5f);
//            photoView.setImageBitmap(piclistBitmap.get(position));
//            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            return photoView;
        }

    }


}

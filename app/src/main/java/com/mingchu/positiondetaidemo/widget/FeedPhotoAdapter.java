package com.mingchu.positiondetaidemo.widget;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mingchu.positiondetaidemo.R;
import com.mingchu.positiondetaidemo.imageloader.ImageLoader;

import java.util.List;

public class FeedPhotoAdapter extends BaseWeiBoAdapter<String> {

    private int mColumnWidth;

    private LayoutInflater mInflater;

    public FeedPhotoAdapter(Activity context, List<String> mEntities, int mColumnWidth) {
        super(context, mEntities);
        this.mColumnWidth = mColumnWidth;
        this.mInflater = context.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String item = getDatas().get(position);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_feed_photo, null);
        }
        ImageView photo = ViewHolder.get(convertView, R.id.iv_photo);
        ViewGroup.LayoutParams params = photo.getLayoutParams();
        params.width = mColumnWidth;
        params.height = mColumnWidth;
        photo.setLayoutParams(params);
//        photo.setImageResource(item.getLocalRes());
        ImageLoader.load(item,photo);
        return convertView;
    }
}

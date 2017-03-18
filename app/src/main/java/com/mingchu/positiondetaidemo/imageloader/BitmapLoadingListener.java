package com.mingchu.positiondetaidemo.imageloader;

import android.graphics.Bitmap;

/**
 *
 */

public interface BitmapLoadingListener {

    void onSuccess(Bitmap b);

    void onError();
}

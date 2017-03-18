package com.mingchu.positiondetaidemo;

import android.app.Application;

import com.mingchu.positiondetaidemo.attention.MultiTypeInstaller;


public class MyApp extends Application {




    @Override
    public void onCreate() {
        super.onCreate();


        MultiTypeInstaller.start();

        scale = getResources().getDisplayMetrics().density;
    }

    private static float scale;




    /**
     * dp转成px
     *
     * @param dipValue 想要实现的dp值
     * @return px值
     */

    public static int dip2px(int dipValue) {
        return (int) (dipValue * scale + 0.5f);
    }

}

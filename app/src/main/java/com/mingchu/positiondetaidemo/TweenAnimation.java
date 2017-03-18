package com.mingchu.positiondetaidemo;

import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;


/**
 * Created by lcc on 16/6/1.
 */
public class TweenAnimation {

    public static void showAnimation(final View view) {

        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        Animation translateAnimation = new TranslateAnimation(0f, 0f, 0f, -200.0f);
        //动画集
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(translateAnimation);
        set.addAnimation(alphaAnimation);

//设置动画时间 (作用到每个动画)
        set.setDuration(566);
        view.startAnimation(set);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
                Log.d("ruolanmingyue", "到这了   rl_zan_animaition");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }


    public static void showAnimationGONE(final View view) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        Animation translateAnimation = new TranslateAnimation(0f, 0f, 0f, -200.0f);
        //动画集
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(translateAnimation);
        set.addAnimation(alphaAnimation);
//设置动画时间 (作用到每个动画)
        set.setDuration(566);
        view.startAnimation(set);

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
                Toast.makeText(view.getContext(), "但这里额么", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}

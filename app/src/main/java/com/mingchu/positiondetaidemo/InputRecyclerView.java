package com.mingchu.positiondetaidemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;


public class InputRecyclerView extends RecyclerView {
    public InputRecyclerView(Context context) {
        super(context);
    }

    public InputRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InputRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

//    @Override
//    public boolean onInterceptHoverEvent(MotionEvent event) {
//
//        return false;
//    }


//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//
//        // 触摸时禁止轮播
//        final float[] startX = new float[1];
//        final float[] startY = new float[1];
//
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                startX[0] = event.getX();
//                startY[0] = event.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//
//
//                float endX1 = event.getX();
//                float endY1 = event.getY();
//
//                float dx = endX1 - startX[0];
//                float dy = endY1 - startY[0];
//
//                if (Math.abs(dy)>10){
//                    Toast.makeText(getContext(), "滑动时间", Toast.LENGTH_SHORT).show();
//                    return true;
//                } else {
//                    return false;
//                }
//
//
////            case MotionEvent.ACTION_CANCEL:
////
////                // 一种情景，按下view pager 后滑动listView 失去了up事件导致无法轮播 但走次事件
////                float eX = event.getX();
////                float eY = event.getY();
////
////                float dex = eX - startX[0];
////                float dey = eY - startY[0];
////                if (Math.abs(dex) < Math.abs(dey)) {
////                    //
////
////                }
////                //Toast.makeText(getActivity(), "CANCEL", Toast.LENGTH_SHORT).show();
////                break;
//
//
//            case MotionEvent.ACTION_UP:
//                float endX = event.getX();
//                float endY = event.getY();
//
////                float dx = endX - startX[0];
////                float dy = endY - startY[0];
////                //区分点击事件还是移动事件
////                if (Math.abs(dy) > 7) {
////                    // Toast.makeText(getContext(), dx + "", Toast.LENGTH_SHORT).show();
////                    //点击事件
////
////                    return true;
////                } else {
////                    Toast.makeText(getContext(), "点击事件", Toast.LENGTH_SHORT).show();
////                }
//
//                break;
//        }
//
//        return super.dispatchTouchEvent(event);
//    }
}

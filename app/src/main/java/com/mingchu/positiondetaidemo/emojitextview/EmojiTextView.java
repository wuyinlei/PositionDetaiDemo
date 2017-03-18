package com.mingchu.positiondetaidemo.emojitextview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 这个貌似没有什么用啊我去。。。。。。
 */
public class EmojiTextView extends TextView {


    private final Context mContext;

    public EmojiTextView(Context context) {
        super(context, null);
        mContext = context;
    }

    public EmojiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

}

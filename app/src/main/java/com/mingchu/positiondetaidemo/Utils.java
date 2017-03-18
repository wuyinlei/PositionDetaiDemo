package com.mingchu.positiondetaidemo;

import android.content.Context;
import android.util.TypedValue;

import com.mingchu.positiondetaidemo.emojitextview.EmojiTextView;
import com.mingchu.positiondetaidemo.emojitextview.WeiBoContentTextUtil;

import java.util.List;

/**
 * Created by wuyinlei on 2017/3/10.
 */

public class Utils {

    /**
     * 转换问题标志
     * @param strings
     * @return
     */
    public static String getStringQuestionType(List<String> strings){
        StringBuffer sb = new StringBuffer();
        for (String string : strings) {
            sb.append("#");
            sb.append(string);
            sb.append(",");
        }
        return sb.toString();
    }

    public static int getStatusHeight(Context context) {

        int statusHeight = -1;
        try {
            Class clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    public static int getActionBarHeight(Context context) {
        int mActionBarHeight;
        TypedValue mTypedValue = new TypedValue();

        context.getTheme().resolveAttribute(R.attr.actionBarSize, mTypedValue, true);

        mActionBarHeight = TypedValue.complexToDimensionPixelSize(mTypedValue.data, context.getResources().getDisplayMetrics());

        return mActionBarHeight;
    }



    /**
     * 填充原创微博文字内容
     */
    public static void fillWeiBoContent(String text, Context context, EmojiTextView weibo_content) {
        weibo_content.setText(WeiBoContentTextUtil.getWeiBoContent(text, context, weibo_content));
        //weibo_content.setText(text);
    }


}

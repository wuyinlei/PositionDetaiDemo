package com.mingchu.positiondetaidemo.attention;

import com.mingchu.positiondetaidemo.attention.adapter.AttentionProAdapter;
import com.mingchu.positiondetaidemo.attention.adapter.CommentProAdapter;
import com.mingchu.positiondetaidemo.attention.adapter.FoodProAdapter;
import com.mingchu.positiondetaidemo.attention.adapter.LookMoreProAdapter;

import me.drakeet.multitype.GlobalMultiTypePool;

/**
 * Created by wuyinlei on 2017/3/11.
 */

public class MultiTypeInstaller {

    public static void start() {
//        GlobalMultiTypePool.registerter();
//        GlobalMultiTypePool.register();

        GlobalMultiTypePool.register(AttentionBean.class,new AttentionProAdapter());
        GlobalMultiTypePool.register(Comment.class,new CommentProAdapter());

        GlobalMultiTypePool.register(LookMoreBean.class,new LookMoreProAdapter());

        GlobalMultiTypePool.register(PublishBean.class,new FoodProAdapter());
    }
}

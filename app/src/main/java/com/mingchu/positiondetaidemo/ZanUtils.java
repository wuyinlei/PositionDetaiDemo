package com.mingchu.positiondetaidemo;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ZanUtils {

    //点赞状态
    static String psUtils = 0 + "";
    //点赞总数
    static String zanCountUtils = 0 + "";

    public static void loginACtivity(Activity mActivity) {
        // TODO Auto-generated method stub
//        Intent intent = new Intent(mActivity, LoginActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        mActivity.startActivity(intent);
        // 关闭当前界面使按返回键时能够返回到桌面
        //  mActivity.finish();
        mActivity.overridePendingTransition(0, 0);
    }


    public static String clickZan(Activity mActivity, String type, String id, String zanCount,
                                  Button bt_zan, TextView tv_food_zan, String ps,
                                  Button iv_zan_animation, TextView tv_zan_past) {
        psUtils = ps;
        zanCountUtils = zanCount;
//        String token = MyApp.user.getAuth_token();
//        String uid = MyApp.user.getUid();
        if (TextUtils.isEmpty("dfa")) {  //// TODO: 2017/3/13  模拟登陆
            //
//            Toast.makeText(mActivity, R.string.longin, Toast.LENGTH_SHORT).show();
//            loginACtivity(mActivity);
        } else {
            //根据点赞状态判断是否请求服务器

            final int psZan = Integer.parseInt(ps);
            if (psZan == 1) {
//                //已经点赞,取消点赞
//                DelPraiseFromService.delPrise(mActivity, type, id, uid, token);
//                bt_zan.setBackgroundResource(R.mipmap.icon_good);
//                iv_zan_animation.setBackgroundResource(R.mipmap.icon_good);
//                // final int i = Integer.parseInt(zanCount) - 1;
//                if (zanCount.equals("99+") || Integer.parseInt(zanCount) - 1 > 99) {
//                    tv_food_zan.setText(99 + "+");
//                    //设置ps的状态
//                    psUtils = 0 + "";
//                    zanCountUtils = 99 + "+";
//
//                } else {
//                    tv_food_zan.setText(Integer.parseInt(zanCount) - 1 + "");
//                    //设置ps的状态
//                    psUtils = 0 + "";
//                    zanCountUtils = Integer.parseInt(zanCount) - 1 + "";
//
//                }
                //2.0.2 版本新加
                psUtils = 1 + "";
                zanCountUtils = Integer.parseInt(zanCount) + "";

                tv_zan_past.setVisibility(View.VISIBLE);

                TweenAnimation.showAnimationGONE(tv_zan_past);


            } else {
                //没有点赞,进行点赞

                TweenAnimation.showAnimation(iv_zan_animation);
//                GetPraiseFromService.addCommentService(mActivity, type, id, uid, token);
                //更改图标
                bt_zan.setBackgroundResource(R.mipmap.food_tab_good_copy);
                iv_zan_animation.setBackgroundResource(R.mipmap.food_tab_good_copy);
                //     int i = Integer.parseInt(zanCount) + 1;
                if (zanCount.equals("99+") || Integer.parseInt(zanCount) + 1 > 99) {
                    tv_food_zan.setText(99 + "+");
                    //设置ps的状态
                    psUtils = 1 + "";
                    zanCountUtils = 99 + "+";

                } else {

                    tv_food_zan.setText(Integer.parseInt(zanCount) + 1 + "");
                    psUtils = 1 + "";
                    zanCountUtils = Integer.parseInt(zanCount) + 1 + "";
                }
            }


        }
        return psUtils + "-" + zanCountUtils;
    }


    /**
     *
     * @param mActivity  上下文
     * @param type  类型
     * @param id  id
     * @param zanCount 赞的个数
     * @param bt_zan  点赞的按钮
     * @param tv_food_zan
     * @param ps
     * @param iv_zan_animation  赞过了的按钮
     * @param tv_zan_past   赞过了TextView
     * @param rl_zan_animaition  RelativeLayout
     * @return
     */
    public static String clickZan(Context mActivity,
                                  String type,
                                  String id,
                                  String zanCount,
                                  Button bt_zan,
                                  TextView tv_food_zan,
                                  String ps,
                                  Button iv_zan_animation,
                                  TextView tv_zan_past,
                                  View rl_zan_animaition) {
        psUtils = ps;
        zanCountUtils = zanCount;
//        String token = MyApp.user.getAuth_token();
//        String uid = MyApp.user.getUid();
        if (TextUtils.isEmpty("ad")) {
            //
//            Toast.makeText(mActivity, R.string.longin, Toast.LENGTH_SHORT).show();
//            loginACtivity(mActivity);
        } else {
            //根据点赞状态判断是否请求服务器
            final int psZan = Integer.parseInt(ps);
            if (psZan == 1) {
//                //已经点赞,取消点赞
//                DelPraiseFromService.delPrise(mActivity, type, id, uid, token);
                bt_zan.setBackgroundResource(R.mipmap.food_tab_good_copy);
                iv_zan_animation.setBackgroundResource(R.mipmap.food_tab_good_copy);
//                // final int i = Integer.parseInt(zanCount) - 1;
//                if (zanCount.equals("99+") || Integer.parseInt(zanCount) - 1 > 99) {
//                    tv_food_zan.setText(99 + "+");
//                    //设置ps的状态
//                    psUtils = 0 + "";
//                    zanCountUtils = 99 + "+";
//
//                } else {
//                    tv_food_zan.setText(Integer.parseInt(zanCount) - 1 + "");
//                    //设置ps的状态
//                    psUtils = 0 + "";
//                    zanCountUtils = Integer.parseInt(zanCount) - 1 + "";
//
//                }
                //2.0.2 版本新加
                psUtils = 1 + "";
                zanCountUtils = Integer.parseInt(zanCount) + "";
                tv_zan_past.setVisibility(View.VISIBLE);
                TweenAnimation.showAnimationGONE(tv_zan_past);

            } else {
                //没有点赞,进行点赞
                rl_zan_animaition.setVisibility(View.VISIBLE);
                TweenAnimation.showAnimation(rl_zan_animaition);
//                GetPraiseFromService.addCommentService(mActivity, type, id, uid, token);
                //更改图标
                bt_zan.setBackgroundResource(R.mipmap.food_tab_good_copy);
                iv_zan_animation.setBackgroundResource(R.mipmap.food_tab_good_copy);
                //     int i = Integer.parseInt(zanCount) + 1;
                if (zanCount.equals("99+") || Integer.parseInt(zanCount) + 1 > 99) {
                    tv_food_zan.setText(99 + "+");
                    //设置ps的状态
                    psUtils = 1 + "";
                    zanCountUtils = 99 + "+";

                } else {
                    tv_food_zan.setText(Integer.parseInt(zanCount) + 1 + "");
                    psUtils = 1 + "";
                    zanCountUtils = Integer.parseInt(zanCount) + 1 + "";
                }
            }


        }
        return psUtils + "-" + zanCountUtils;
    }


}

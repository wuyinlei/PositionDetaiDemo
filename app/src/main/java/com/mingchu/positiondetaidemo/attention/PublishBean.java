package com.mingchu.positiondetaidemo.attention;

import java.io.Serializable;

/**
 * Created by wuyinlei on 2017/3/11.
 */

/**
 * 自己发布的作品
 */
public class PublishBean implements Serializable {

    private String username; //用户名
    private String imgurl;  //头像地址
    private String company; //公司

    private String content;//自己发布的文字
    private String productimg;//发布作品的地址(如果为空呢)
    private String productname;//发布的作品名字

    private String publishtime; //发布时间
    private String commentcount;//评论个数
    private String apprpvalcount;//点赞个数

    private int flag = 0;//  是否赞了
    private int fly = 0;

    public void setFly(int fly) {
        this.fly = fly;
    }

    public int getFly() {
        return fly;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProductimg() {
        return productimg;
    }

    public void setProductimg(String productimg) {
        this.productimg = productimg;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(String commentcount) {
        this.commentcount = commentcount;
    }

    public String getApprpvalcount() {
        return apprpvalcount;
    }

    public void setApprpvalcount(String apprpvalcount) {
        this.apprpvalcount = apprpvalcount;
    }
}

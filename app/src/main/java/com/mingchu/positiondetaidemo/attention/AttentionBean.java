package com.mingchu.positiondetaidemo.attention;

import java.io.Serializable;
import java.util.List;


/**
 * 关注人员发布的作品
 */
public class AttentionBean implements Serializable {


    private String username; //用户名
    private String imgurl;  //头像地址
    private String company; //公司
    private String post; //职位
    private List<String> types; //发布内容所属type
    private String content;  //发布的内容
    private List<String> imgUrls;//发布的图片
    private String publishtime; //发布时间
    private String commentcount;//评论个数
    private String apprpvalcount;//点赞个数

    private List<Comment> mComments;  //评论

    private LookMoreBean mMoreBean;

    public void setMoreBean(LookMoreBean moreBean) {
        mMoreBean = moreBean;
    }

    public LookMoreBean getMoreBean() {
        return mMoreBean;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
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

    public List<Comment> getComments() {
        return mComments;
    }

    public void setComments(List<Comment> comments) {
        mComments = comments;
    }
}

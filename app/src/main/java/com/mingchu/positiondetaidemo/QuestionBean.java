package com.mingchu.positiondetaidemo;

import java.lang.reflect.GenericArrayType;
import java.util.List;

/**
 * Created by wuyinlei on 2017/3/10.
 */

public class QuestionBean {

    private String userimgurl; //头像地址
    private String username; //用户名称
    private String usertype;//甜品师
    private String userplace; //公司

    private String questioncontent;

    public String getUserimgurl() {
        return userimgurl;
    }

    public void setUserimgurl(String userimgurl) {
        this.userimgurl = userimgurl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUserplace() {
        return userplace;
    }

    public void setUserplace(String userplace) {
        this.userplace = userplace;
    }

    public void setQuestioncontent(String questioncontent) {
        this.questioncontent = questioncontent;
    }


    public String getQuestioncontent() {
        return questioncontent;
    }

    private List<String> questiontype;

    public void setQuestiontype(List<String> questiontype) {
        this.questiontype = questiontype;
    }

    public List<String> getQuestiontype() {
        return questiontype;
    }

    private List<String> imgurl; //图片产品地址


    public List<String> getImgurl() {
        return imgurl;
    }

    public void setImgurl(List<String> imgurl) {
        this.imgurl = imgurl;
    }



    public static class CommentUser{
        private String commentusername;
        private String commentdetail;

        public String getCommentusername() {
            return commentusername;
        }

        public void setCommentusername(String commentusername) {
            this.commentusername = commentusername;
        }

        public String getCommentdetail() {
            return commentdetail;
        }

        public void setCommentdetail(String commentdetail) {
            this.commentdetail = commentdetail;
        }
    }

    private CommentUser mCommentUser;

    public CommentUser getCommentUser() {
        return mCommentUser;
    }

    public void setCommentUser(CommentUser commentUser) {
        mCommentUser = commentUser;
    }

    private int commentcount;

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }
}

package com.mingchu.positiondetaidemo.attention;

import java.io.Serializable;


/**
 * 评论
 */
public class Comment implements Serializable {

    private String commentuser; //发布评论人员名字
    private String byreviewsuser;//被评论人员名字
    private String content;//评论内容

    public String getCommentuser() {
        return commentuser;
    }

    public void setCommentuser(String commentuser) {
        this.commentuser = commentuser;
    }

    public String getByreviewsuser() {
        return byreviewsuser;
    }

    public void setByreviewsuser(String byreviewsuser) {
        this.byreviewsuser = byreviewsuser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

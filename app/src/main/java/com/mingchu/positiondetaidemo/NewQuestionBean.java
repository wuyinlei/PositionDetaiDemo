package com.mingchu.positiondetaidemo;

import java.io.Serializable;

/**
 * Created by wuyinlei on 2017/3/10.
 */

public class NewQuestionBean implements Serializable {

    String content;
    String username;
    String answercount;
    String attentioncount;
    String type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAnswercount() {
        return answercount;
    }

    public void setAnswercount(String answercount) {
        this.answercount = answercount;
    }

    public String getAttentioncount() {
        return attentioncount;
    }

    public void setAttentioncount(String attentioncount) {
        this.attentioncount = attentioncount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

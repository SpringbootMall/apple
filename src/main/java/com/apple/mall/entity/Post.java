package com.apple.mall.entity;

public class Post {

    private int postId;
    private String user;
    private String postContent;
    private int thumbNumber;
    private String postTime;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getThumbNumber() {
        return thumbNumber;
    }

    public void setThumbNumber(int thumbNumber) {
        this.thumbNumber = thumbNumber;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }
}
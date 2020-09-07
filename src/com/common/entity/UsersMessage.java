package com.common.entity;

import java.util.Date;

/**
 * 用户读取消息
 * @author Maple
 */
public class UsersMessage {
    public static final String TABLE_NAME = "users_message";
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 消息来源id
     */
    private Long fromId;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 消息标题
     */
    private String title;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 读取时间
     */
    private Date readTime;
    /**
     * 状态值
     */
    private Boolean isRead;
    /**
     *  创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;
    /**
     * 接收时间
     */
    private Date releaseTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public UsersMessage() {
    }
}

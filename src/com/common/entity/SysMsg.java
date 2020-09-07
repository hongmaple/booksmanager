package com.common.entity;

import java.util.Date;

/**
 * 消息表（写）
 * 由管理员创建消息
 * @author Maple
 */
public class SysMsg {
    public static final String TABLE_NAME = "sys_msg";
    /**
     * 自增主键
     */
    private Long id;
    /**
     * 消息标题
     */
    private String title;
    /**
     * 发布人id
     */
    private Long issuerId;
    /**
     *  发布人
     */
    private String issuer;
    /**
     *  接受对象
     */
    private String accept;
    /**
     *  消息内容
     */
    private String content;
    /**
     *  提醒方式
     */
    private Integer remindWay;
    /**
     *  发布时间
     */
    private Date releaseTime;
    /**
     *  有效期
     */
    private Date indateTime;

    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 逻辑删除
     */
    private Boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Long issuerId) {
        this.issuerId = issuerId;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRemindWay() {
        return remindWay;
    }

    public void setRemindWay(Integer remindWay) {
        this.remindWay = remindWay;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getIndateTime() {
        return indateTime;
    }

    public void setIndateTime(Date indateTime) {
        this.indateTime = indateTime;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public SysMsg() {
    }

    public SysMsg(Long id, String title, Long issuerId, String issuer, String accept, String content, Integer remindWay, Date releaseTime, Date indateTime, Date createdTime, Date updatedTime, Boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.issuerId = issuerId;
        this.issuer = issuer;
        this.accept = accept;
        this.content = content;
        this.remindWay = remindWay;
        this.releaseTime = releaseTime;
        this.indateTime = indateTime;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.isDeleted = isDeleted;
    }
}

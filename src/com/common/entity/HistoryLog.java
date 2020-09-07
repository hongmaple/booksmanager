package com.common.entity;

import java.util.Date;

/**
 * 借阅日志实体
 * @author Maple
 */
public class HistoryLog {
    public static final String TABLE_NAME = "history_log";
    /**
     * 主键
     */
    private Long id;
    /**
     * 借阅表id
     */
    private int histotyId;
    /**
     * 借阅状态
     */
    private String status;
    /**
     * 操作者，跟Users主键关联
     */
    private int operatorId;
    /**
     * 创建时间，操作时间
     */
    private Date createdTime;
    /**
     * 是否删除,数据库中：0未删除，1删除，实体中fasle未删除，true删除
     */
    private Boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHistotyId() {
        return histotyId;
    }

    public void setHistotyId(int histotyId) {
        this.histotyId = histotyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public HistoryLog() {
    }

    public HistoryLog(Long id, int histotyId, String status, int operatorId, Date createdTime, Boolean isDeleted) {
        this.id = id;
        this.histotyId = histotyId;
        this.status = status;
        this.operatorId = operatorId;
        this.createdTime = createdTime;
        this.isDeleted = isDeleted;
    }
}

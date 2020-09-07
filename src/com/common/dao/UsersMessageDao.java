package com.common.dao;

import com.common.entity.SysMsg;
import com.common.entity.UsersMessage;
import com.common.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersMessageDao {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    MessageCenterDao messageCenterDao = new MessageCenterDao();


    public int  save(UsersMessage sysMsg){

        String sql = "insert into " +
                "users_message (from_id,user_id,title,content,is_read," +
                "release_time,created_time,updated_time) " +
                "values(?,?,?,?,?,?,?,?)";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,sysMsg.getFromId());
            pstmt.setObject(2,sysMsg.getUserId());
            pstmt.setObject(3,sysMsg.getTitle());
            pstmt.setObject(4,sysMsg.getContent());
            pstmt.setObject(5,false);
            pstmt.setObject(6,sysMsg.getReleaseTime());
            pstmt.setObject(7,new Date());
            pstmt.setObject(8,new Date());
            int i =  pstmt.executeUpdate();
            return i;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtil.close(conn,pstmt);
        }
        return 0;
    }

    public List<UsersMessage> searchList(int userId,String title){

        Long fromId = selectRecentFromId(userId);
        if (fromId==null){
            fromId = 0L;
        }
        List<SysMsg> sysMessages = messageCenterDao.selectNotExpiredMsg(fromId);
        if (sysMessages.size()>0){
            for(SysMsg sysMsg : sysMessages){
                UsersMessage message = new UsersMessage();
                message.setTitle(sysMsg.getTitle());
                message.setContent(sysMsg.getContent());
                message.setFromId(sysMsg.getId());
                message.setUserId(userId);
                message.setRead(false);
                message.setReleaseTime(sysMsg.getReleaseTime());
                save(message);
            }
        }
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT id, title,content,read_time as readTime,release_time as releaseTime, is_read as isRead,created_time createdTime,updated_time updatedTime FROM users_message WHERE user_id = ?");
        if (title!=null&&!title.isEmpty()){
            sql.append(" AND title LIKE CONCAT('%',?,'%')");
        }
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1,userId);
            if (title!=null&&!title.isEmpty()){
                pstmt.setObject(2,title);
            }
            rs = pstmt.executeQuery();
            List<UsersMessage> list = new ArrayList<>();
            // 获取查询的值
            while (rs.next()) {
                UsersMessage sysMsg = new UsersMessage();
                sysMsg.setId(rs.getLong("id"));
                sysMsg.setReadTime(rs.getDate("readTime"));
                sysMsg.setRead(rs.getBoolean("isRead"));
                sysMsg.setContent(rs.getString("content"));
                sysMsg.setTitle(rs.getString("title"));
                sysMsg.setCreatedTime(rs.getDate("createdTime"));
                sysMsg.setReleaseTime(rs.getDate("releaseTime"));
                sysMsg.setUpdatedTime(rs.getDate("updatedTime"));

                list.add(sysMsg);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取指定用户最新的消息来源ID
     * @param userId 用户ID
     * @return 消息来源ID
     */
    public Long selectRecentFromId( int userId){
        String sql = "SELECT MAX(from_id) fromId FROM users_message WHERE user_id = ?";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1,userId);
            rs = pstmt.executeQuery();
            Long id = null;
            while (rs.next()){
                id = rs.getLong("fromId");
            }
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

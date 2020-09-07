package com.common.dao;

import com.common.entity.SysMsg;
import com.common.entity.Users;
import com.common.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 消息中心，写
 */
public class MessageCenterDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    /**
     * MethodName :保存
     * Description: 将一个属性与数据库表属性相对应的对象插入到数据库中
     * @param sysMsg 数据对象
     */
    public int  save(SysMsg sysMsg){

        String sql = "insert into \n" +
                "sys_msg(`title`,`issuer_id`,`issuer`,`accept`,`content`,`remind_way`\n" +
                ",`indate_time`,`release_time`,`created_time`,`updated_time`)\n" +
                "values(?,?,?,?,?,?,?,?,?,?)";

        sysMsg.setIssuer("admin");
        sysMsg.setIssuerId(1L);
        Date now = new Date();
        sysMsg.setCreatedTime(now);
        sysMsg.setUpdatedTime(now);
        sysMsg.setReleaseTime(now);
        sysMsg.setRemindWay(1);
        sysMsg.setAccept(String.valueOf(0));

        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,sysMsg.getTitle());
            pstmt.setObject(2,sysMsg.getIssuerId());
            pstmt.setObject(3,sysMsg.getIssuer());
            pstmt.setObject(4,sysMsg.getAccept());
            pstmt.setObject(5,sysMsg.getContent());
            pstmt.setObject(6,sysMsg.getRemindWay());
            pstmt.setObject(7,sysMsg.getIndateTime());
            pstmt.setObject(8,sysMsg.getReleaseTime());
            pstmt.setObject(9,sysMsg.getCreatedTime());
            pstmt.setObject(10,sysMsg.getUpdatedTime());
            int i =  pstmt.executeUpdate();
            return i;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtil.close(conn,pstmt);
        }
        return 0;
    }

    public List<SysMsg> searchList(String title){
        String sql = "SELECT id,title,accept,content,issuer,issuer_id issuerId,remind_way as remindWay," +
                     "indate_time as indateTime, release_time as releaseTime,created_time createdTime,updated_time updatedTime" +
                     " FROM sys_msg";
        if (title!=null&&!title.isEmpty()){
            sql += " WHERE title LIKE CONCAT('%',?,'%')";
        }
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            if (title!=null&&!title.isEmpty()){
                pstmt.setObject(1,title);
            }
            rs = pstmt.executeQuery();
            List<SysMsg> list = new ArrayList<>();
            // 获取查询的值
            while (rs.next()) {
                SysMsg sysMsg = new SysMsg();
                sysMsg.setId(rs.getLong("id"));
                sysMsg.setIssuer(rs.getString("issuer"));
                sysMsg.setIssuerId(rs.getLong("issuerId"));
                sysMsg.setRemindWay(rs.getInt("remindWay"));
                sysMsg.setIndateTime(rs.getDate("indateTime"));
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
     * 获取未过期的消息
     * @param fromId 消息来源ID
     * @return 消息列表
     */
    public List<SysMsg> selectNotExpiredMsg(Long fromId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT id, title, content,release_time as releaseTime FROM `sys_msg`");
        sql.append("WHERE accept in (0, 1) AND indate_time > NOW() AND id > ?");
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setLong(1,fromId);
            rs = pstmt.executeQuery();
            List<SysMsg> list = new ArrayList<>();
            while (rs.next()) {
                SysMsg sysMsg = new SysMsg();
                sysMsg.setId(rs.getLong("id"));
                sysMsg.setContent(rs.getString("content"));
                sysMsg.setTitle(rs.getString("title"));
                sysMsg.setReleaseTime(rs.getDate("releaseTime"));

                list.add(sysMsg);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.common.dao;

import com.common.entity.Book;
import com.common.entity.History;
import com.common.util.DbUtil;
import com.common.util.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* ClassName:HistoryDao
* Description:
*/
public class HistoryDao{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    /**
    * MethodName :保存
    * Description: 将一个属性与数据库表属性相对应的对象插入到数据库中
    * @param history 数据对象
    */
    public int  save(History history){

        String sql = "insert into history (id,username,bookname,lendtime,backtime,remark,status)  values (? ,? ,? ,? ,? ,? ,?)" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,null);
            pstmt.setObject(2,history.getUsername());
            pstmt.setObject(3,history.getBookname());
            pstmt.setObject(4,history.getLendtime());
            pstmt.setObject(5,history.getBacktime());
            pstmt.setObject(6,history.getRemark());
            pstmt.setObject(7,history.getStatus());
            int i =  pstmt.executeUpdate();
            return i;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtil.close(conn,pstmt);
        }
        return 0;
    }

    /**
    * MethodName: 删除
    * Description: 将一个属性与数据库表属性相对应的对象从数据库中删除(通过设置该对象id,通过id删除信息记录)
    */
    public int delete(int id){
        String sql = "delete from history  where id = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            int i = pstmt.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return 0;
    }

    /**
    * MethodName 修改
    * Description 通过id修改数据库表
    * @param history 与数据库表对应的对象
    */
    public int update(History history) {
        String sql = "update history set id = ?,username = ?,bookname = ?,lendtime = ?,backtime = ?,remark = ?,status = ? where id = ?";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,history.getId());
            pstmt.setObject(2,history.getUsername());
            pstmt.setObject(3,history.getBookname());
            pstmt.setObject(4,history.getLendtime());
            pstmt.setObject(5,history.getBacktime());
            pstmt.setObject(6,history.getRemark());
            pstmt.setObject(7,history.getStatus());
            pstmt.setInt(8,history.getId());
            int i = pstmt.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return 0;
    }

    /**
    * MethodName 查询
    * Description 通过id查询数据库信息记录(通过设置该对象id,通过id查询信息记录)
    */
    public History queryById(int id){
        String sql = "select * from history where id = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                History history = new History();
                history.setId(rs.getInt("id"));
                history.setUsername(rs.getString("username"));
                history.setBookname(rs.getString("bookname"));
                history.setLendtime(rs.getString("lendtime"));
                history.setBacktime(rs.getString("backtime"));
                history.setRemark(rs.getString("remark"));
                history.setStatus(rs.getString("status"));
                return history;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return null;
    }

    public List<History> queryByName(String name){
        String sql = "select * from history where username = ?" ;
        List<History> list = new ArrayList<History>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            Class clazz = History.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                History history = new History();
                history.setId(rs.getInt("id"));
                history.setUsername(rs.getString("username"));
                history.setBookname(rs.getString("bookname"));
                history.setLendtime(rs.getString("lendtime"));
                history.setBacktime(rs.getString("backtime"));
                history.setRemark(rs.getString("remark"));
                history.setStatus(rs.getString("status"));
                list.add(history);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return list;
    }


    /**
    * MethodName 查询
    * Description 通过id查询数据库信息记录(通过设置该对象id,通过id查询信息记录)
    */
    public List<History> queryAll(){
        String sql = "select * from history" ;
        List<History> list = new ArrayList<History>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = History.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                History history = new History();
                history.setId(rs.getInt("id"));
                history.setUsername(rs.getString("username"));
                history.setBookname(rs.getString("bookname"));
                history.setLendtime(rs.getString("lendtime"));
                history.setBacktime(rs.getString("backtime"));
                history.setRemark(rs.getString("remark"));
                history.setStatus(rs.getString("status"));
                list.add(history);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return list;
    }

    public List<History> queryOutTime(){
        String sql = "select * from history where date_format(remark,'%Y-%m-%d')>date_format(backtime,'%Y-%m-%d')" ;
        List<History> list = new ArrayList<History>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = History.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                History history = new History();
                history.setId(rs.getInt("id"));
                history.setUsername(rs.getString("username"));
                history.setBookname(rs.getString("bookname"));
                history.setLendtime(rs.getString("lendtime"));
                history.setBacktime(rs.getString("backtime"));
                history.setRemark(rs.getString("remark"));
                history.setStatus(rs.getString("status"));
                list.add(history);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return list;
    }

    public List<History> queryOutTimeByname(String name){
        String sql = "select * from history where date_format(remark,'%Y-%m-%d')>date_format(backtime,'%Y-%m-%d') and username=?" ;
        List<History> list = new ArrayList<History>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            Class clazz = History.class;
            rs = pstmt.executeQuery();

            // 获取查询的值
            while (rs.next()) {
                History history = new History();
                history.setId(rs.getInt("id"));
                history.setUsername(rs.getString("username"));
                history.setBookname(rs.getString("bookname"));
                history.setLendtime(rs.getString("lendtime"));
                history.setBacktime(rs.getString("backtime"));
                history.setRemark(rs.getString("remark"));
                history.setStatus(rs.getString("status"));
                list.add(history);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return list;
    }
    public List<History> serch(History c) throws SQLException {
        QueryRunner qr = new TxQueryRunner();
        StringBuffer sql = new StringBuffer("select * from history where 1=1"); //重点。 此处解决掉了条件如何拼接的问题

        List<Object> list = new ArrayList<Object>();

        if (c.getUsername() != null && !c.getUsername().trim().isEmpty()) {

            sql.append(" and username like \"%\"?\"%\"");//and前面需要一个空格，与前面的内容分离开

            list.add(c.getUsername());//把参数添加到 list 中

        }

        if (c.getBookname() != null && !c.getBookname().trim().isEmpty()) {

            sql.append(" and bookname like \"%\"?\"%\"");//and前面需要一个空格，与前面的内容分离开

            list.add(c.getBookname());

        }


        return qr.query(sql.toString(), new BeanListHandler<History>(History.class), list.toArray());//返回结果

    }

}

package com.common.dao;

import com.common.entity.Users;
import com.common.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
* ClassName:UsersDao
* Description:
*/
public class UsersDao{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    /**
    * MethodName :保存
    * Description: 将一个属性与数据库表属性相对应的对象插入到数据库中
    * @param users 数据对象
    */
    public int  save(Users users){

        String sql = "insert into users (id,name,password,gender,phonenumber,address,type)  values (? ,? ,? ,? ,? ,? ,?)" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,null);
            pstmt.setObject(2,users.getName());
            pstmt.setObject(3,users.getPassword());
            pstmt.setObject(4,users.getGender());
            pstmt.setObject(5,users.getPhonenumber());
            pstmt.setObject(6,users.getAddress());
            pstmt.setObject(7,users.getType());
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
        String sql = "delete from users  where id = ?" ;
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
    * @param users 与数据库表对应的对象
    */
    public int update(Users users) {
        String sql = "update users set id = ?,name = ?,password = ?,gender = ?,phonenumber = ?,address = ?,type = ? where id = ?";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,users.getId());
            pstmt.setObject(2,users.getName());
            pstmt.setObject(3,users.getPassword());
            pstmt.setObject(4,users.getGender());
            pstmt.setObject(5,users.getPhonenumber());
            pstmt.setObject(6,users.getAddress());
            pstmt.setObject(7,users.getType());
            pstmt.setInt(8,users.getId());
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
    public Users queryById(int id){
        String sql = "select * from users where id = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Users users = new Users();
                users.setId(rs.getInt("id"));
                users.setName(rs.getString("name"));
                users.setPassword(rs.getString("password"));
                users.setGender(rs.getString("gender"));
                users.setPhonenumber(rs.getString("phonenumber"));
                users.setAddress(rs.getString("address"));
                users.setType(rs.getString("type"));
                return users;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return null;
    }

    public Users queryByName(String name){
        String sql = "select * from users where name = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setString(1,name);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Users users = new Users();
                users.setId(rs.getInt("id"));
                users.setName(rs.getString("name"));
                users.setPassword(rs.getString("password"));
                users.setGender(rs.getString("gender"));
                users.setPhonenumber(rs.getString("phonenumber"));
                users.setAddress(rs.getString("address"));
                users.setType(rs.getString("type"));
                return users;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return null;
    }
    /**
    * MethodName 查询
    * Description 通过id查询数据库信息记录(通过设置该对象id,通过id查询信息记录)
    */
    public List<Users> queryAll(){
        String sql = "select * from users" ;
        List<Users> list = new ArrayList<Users>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = Users.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Users users = new Users();
                users.setId(rs.getInt("id"));
                users.setName(rs.getString("name"));
                users.setPassword(rs.getString("password"));
                users.setGender(rs.getString("gender"));
                users.setPhonenumber(rs.getString("phonenumber"));
                users.setAddress(rs.getString("address"));
                users.setType(rs.getString("type"));
                list.add(users);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return list;
    }

}

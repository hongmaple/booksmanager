package com.common.dao;

import com.common.entity.Book;
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
* ClassName:BookDao
* Description:
*/
public class BookDao{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    /**
    * MethodName :保存
    * Description: 将一个属性与数据库表属性相对应的对象插入到数据库中
    * @param book 数据对象
    */
    public int  save(Book book){

        String sql = "insert into book (id,isbn,bookname,author,press,type,money,remark)  values (? ,? ,? ,? ,? ,? ,? ,?)" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,null);
            pstmt.setObject(2,book.getIsbn());
            pstmt.setObject(3,book.getBookname());
            pstmt.setObject(4,book.getAuthor());
            pstmt.setObject(5,book.getPress());
            pstmt.setObject(6,book.getType());
            pstmt.setObject(7,book.getMoney());
            pstmt.setObject(8,book.getRemark());
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
        String sql = "delete from book  where id = ?" ;
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
    * @param book 与数据库表对应的对象
    */
    public int update(Book book) {
        String sql = "update book set id = ?,isbn = ?,bookname = ?,author = ?,press = ?,type = ?,money = ?,remark = ? where id = ?";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,book.getId());
            pstmt.setObject(2,book.getIsbn());
            pstmt.setObject(3,book.getBookname());
            pstmt.setObject(4,book.getAuthor());
            pstmt.setObject(5,book.getPress());
            pstmt.setObject(6,book.getType());
            pstmt.setObject(7,book.getMoney());
            pstmt.setObject(8,book.getRemark());
            pstmt.setInt(9,book.getId());
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
    public Book queryById(int id){
        String sql = "select * from book where id = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setIsbn(rs.getString("isbn"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor(rs.getString("author"));
                book.setPress(rs.getString("press"));
                book.setType(rs.getString("type"));
                book.setMoney(rs.getDouble("money"));
                book.setRemark(rs.getString("remark"));
                return book;
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
    public List<Book> queryAll(){
        String sql = "select * from book" ;
        List<Book> list = new ArrayList<Book>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = Book.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setIsbn(rs.getString("isbn"));
                book.setBookname(rs.getString("bookname"));
                book.setAuthor(rs.getString("author"));
                book.setPress(rs.getString("press"));
                book.setType(rs.getString("type"));
                book.setMoney(rs.getDouble("money"));
                book.setRemark(rs.getString("remark"));
                list.add(book);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return list;
    }

    public List<Book> serch(Book c) throws SQLException {
        QueryRunner qr = new TxQueryRunner();
        StringBuffer sql = new StringBuffer("select * from book where 1=1"); //重点。 此处解决掉了条件如何拼接的问题

        List<Object> list = new ArrayList<Object>();

        if (c.getAuthor() != null && !c.getAuthor().trim().isEmpty()) {

            sql.append(" and author like \"%\"?\"%\"");//and前面需要一个空格，与前面的内容分离开

            list.add(c.getAuthor());//把参数添加到 list 中

        }

        if (c.getBookname() != null && !c.getBookname().trim().isEmpty()) {

            sql.append(" and bookname like \"%\"?\"%\"");//and前面需要一个空格，与前面的内容分离开

            list.add(c.getBookname());

        }


        return qr.query(sql.toString(), new BeanListHandler<Book>(Book.class), list.toArray());//返回结果

    }
}

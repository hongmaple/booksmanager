package com.common.servlet;

import com.common.dao.BookDao;
import com.common.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
* ClassName:BookServlet
* Description:
*/
@WebServlet(name = "BookServlet",urlPatterns = "/BookServlet")
public class BookServlet extends HttpServlet {

    BookDao bookDao = new BookDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求编码集 防止接收参数乱码
        request.setCharacterEncoding("utf-8");
        // 设置响应格式为网页编码，编码为utf-8 防止输出乱码
        response.setCharacterEncoding("utf-8");
        if(request.getParameter("type").equals("save")){
            //插入操作业务...
            save(request,response);
        }else if (request.getParameter("type").equals("delete")){
            //删除操作业务...
            delete(request,response);
        }else if (request.getParameter("type").equals("update")){
            //修改操作业务...
            update(request,response);
        }else if (request.getParameter("type").equals("query")){
            //查询所有操作业务...
            query(request,response);
        }else if (request.getParameter("type").equals("query1")){
            //查询所有操作业务...
            query1(request,response);
        }else if (request.getParameter("type").equals("query2")){
            //查询所有操作业务...
            query2(request,response);
        }
        else if (request.getParameter("type").equals("get")){
            //查询id操作业务...
            get(request,response);
        }else if (request.getParameter("type").equals("edit")){
            //查询id获取 跳转编辑页面...
            edit(request,response);
        }else{
            System.err.println("动作类型不匹配！");
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("write something here!");

        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }




    //添加Book信息
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String money=request.getParameter("money");
        String author=request.getParameter("author");
        String isbn=request.getParameter("isbn");
        String remark=request.getParameter("remark");
        String bookname=request.getParameter("bookname");
        String press=request.getParameter("press");
        String type=request.getParameter("type");

        Book obj=new  Book();

        obj.setMoney(Double.valueOf(money));
        obj.setAuthor(author);
        obj.setIsbn(isbn);
        obj.setRemark(remark);
        obj.setBookname(bookname);
        obj.setPress(press);
        obj.setType(type);

        bookDao.save(obj);//调用数据库添加
        response.sendRedirect("BookServlet?type=query");
    }

    //修改Book信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String money=request.getParameter("money");
        String author=request.getParameter("author");
        String isbn=request.getParameter("isbn");
        String remark=request.getParameter("remark");
        String id=request.getParameter("id");
        String bookname=request.getParameter("bookname");
        String press=request.getParameter("press");
        String type=request.getParameter("type");

        Book obj=new  Book();

        obj.setMoney(Double.valueOf(money));
        obj.setAuthor(author);
        obj.setIsbn(isbn);
        obj.setRemark(remark);
         obj.setId(Integer.parseInt(id));
        obj.setBookname(bookname);
        obj.setPress(press);
        obj.setType(type);

        bookDao.update(obj); //调用数据库修改功能
        response.sendRedirect("BookServlet?type=query");
    }


    //根据主键id删除Book信息 id是整数
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        bookDao.delete(id);//调用数据库删除
        response.sendRedirect("BookServlet?type=query");
    }


    //Book查询数据库中的所有数据
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<Book>  bookList=bookDao.queryAll(); //调用数据库查询所有
        request.setAttribute("bookList",bookList);   //绑定接受参数
        request.getRequestDispatcher("bookList.jsp").forward(request,response);
    }

    protected void query1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<Book> bookList = bookDao.queryAll();
        request.setAttribute("bookList",bookList);   //绑定接受参数
        request.getRequestDispatcher("historyAdd.jsp").forward(request,response);
    }

    protected void query2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String author=request.getParameter("author");
        String bookname=request.getParameter("bookname");
        Book book = new Book();
        book.setAuthor(author);
        book.setBookname(bookname);
        List<Book> bookList = null;
        try {
            bookList = bookDao.serch(book);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("bookList",bookList);   //绑定接受参数
        request.getRequestDispatcher("bookList.jsp").forward(request,response);
    }


    //Book根据主键id查询数据
    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Book  book=bookDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("book",book);   //绑定接受参数
        request.getRequestDispatcher("bookUpdate.jsp").forward(request,response);
    }

    //Book根据主键id查询数据 跳转到编辑页面
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Book  book=bookDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("book",book);   //绑定接受参数
        request.getRequestDispatcher("bookUpdate.jsp").forward(request,response);
    }




}

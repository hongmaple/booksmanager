package com.common.servlet;

import com.common.dao.HistoryDao;
import com.common.entity.History;
import com.common.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* ClassName:HistoryServlet
* Description:
*/
@WebServlet(name = "HistoryServlet",urlPatterns = "/HistoryServlet")
public class HistoryServlet extends HttpServlet {

    HistoryDao historyDao = new HistoryDao();

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
        }else if (request.getParameter("type").equals("update1")){
            //修改操作业务...
            update1(request,response);
        }else if (request.getParameter("type").equals("query")){
            //查询所有操作业务...
            query(request,response);
        }else if (request.getParameter("type").equals("query1")){
            //查询所有操作业务...
            query1(request,response);
        }else if (request.getParameter("type").equals("query2")){
            //查询所有操作业务...
            query2(request,response);
        }else if (request.getParameter("type").equals("query3")){
            //查询所有操作业务...
            query3(request,response);
        }else if (request.getParameter("type").equals("get")){
            //查询id操作业务...
            get(request,response);
        }else if (request.getParameter("type").equals("get1")){
            //查询id操作业务...
            get1(request,response);
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




    //添加History信息
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String remark=request.getParameter("remark");
        String bookname=request.getParameter("bookname");
        String lendtime=request.getParameter("lendtime");
        String backtime=request.getParameter("backtime");
        String username=request.getParameter("username");
        String status=request.getParameter("status");

        History obj=new History();

        obj.setRemark(remark);
        obj.setBookname(bookname);
        obj.setLendtime(lendtime);
        obj.setBacktime(backtime);
        obj.setUsername(username);
        obj.setStatus(status);
        Users users = (Users)request.getSession().getAttribute("loginAdmin");
        String name = users.getName();
        historyDao.save(obj);//调用数据库添加

        response.sendRedirect("HistoryServlet?type=get1&name="+name);
    }

    //修改History信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String remark=request.getParameter("remark");
        String id=request.getParameter("id");
        String bookname=request.getParameter("bookname");
        String lendtime=request.getParameter("lendtime");
        String backtime=request.getParameter("backtime");
        String username=request.getParameter("username");
        String status=request.getParameter("status");
        History obj=new History();
        obj.setRemark(remark);
        obj.setId(Integer.parseInt(id));
        obj.setBookname(bookname);
        obj.setLendtime(lendtime);
        obj.setBacktime(backtime);
        obj.setUsername(username);
        obj.setStatus(status);
        Users users = (Users)request.getSession().getAttribute("loginAdmin");
        String name = users.getName();
        historyDao.update(obj); //调用数据库修改功能
        response.sendRedirect("HistoryServlet?type=get1&name="+name);
    }
    //修改History信息
    protected void update1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String remark=request.getParameter("remark");
        String id=request.getParameter("id");
        History history = historyDao.queryById(Integer.parseInt(id));
        history.setStatus(String.valueOf(0));
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        String guihuan = dateFormat.format( now );
        history.setRemark(guihuan);
        Users users = (Users)request.getSession().getAttribute("loginAdmin");
        String name = users.getName();
        historyDao.update(history); //调用数据库修改功能
        response.sendRedirect("HistoryServlet?type=get1&name="+name);
    }



    //根据主键id删除History信息 id是整数
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        historyDao.delete(id);//调用数据库删除
        response.sendRedirect("HistoryServlet?type=query");
    }


    //History查询数据库中的所有数据
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<History>  historyList=historyDao.queryAll(); //调用数据库查询所有
        request.setAttribute("historyList",historyList);   //绑定接受参数
        request.getRequestDispatcher("historyList.jsp").forward(request,response);
    }

    //History查询数据库中的所有数据
    protected void query1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String bookname=request.getParameter("bookname");
        String username=request.getParameter("username");
        History history = new History();
        history.setBookname(bookname);
        history.setUsername(username);
        List<History>  historyList= null; //调用数据库查询所有
        try {
            historyList = historyDao.serch(history);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("historyList",historyList);   //绑定接受参数
        request.getRequestDispatcher("historyList.jsp").forward(request,response);
    }

    protected void query2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<History>  historyList=historyDao.queryOutTime(); //调用数据库查询所有
        request.setAttribute("historyList",historyList);   //绑定接受参数
        request.getRequestDispatcher("OutTimeList.jsp").forward(request,response);
    }

    protected void query3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //调用数据库查询所有方法
        String name=request.getParameter("name");
        List<History>  historyList=historyDao.queryOutTimeByname(name); //调用数据库查询所有
        request.setAttribute("historyList",historyList);   //绑定接受参数
        request.getRequestDispatcher("OutTimeList.jsp").forward(request,response);
    }

    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String id=request.getParameter("id");
        History history=historyDao.queryById(Integer.parseInt(id)); //调用数据库根据主键查询
        request.setAttribute("history",history);   //绑定接受参数
        request.getRequestDispatcher("historyList.jsp").forward(request,response);
    }

    //History根据主键id查询数据
    protected void get1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String name=request.getParameter("name");
        List<History> historyList = historyDao.queryByName(name);//调用数据库根据主键查询
        request.setAttribute("historyList",historyList);   //绑定接受参数
        request.getRequestDispatcher("historyList.jsp").forward(request,response);
    }

    //History根据主键id查询数据 跳转到编辑页面
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        History history=historyDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("history",history);   //绑定接受参数
        request.getRequestDispatcher("historyUpdate.jsp").forward(request,response);
    }




}

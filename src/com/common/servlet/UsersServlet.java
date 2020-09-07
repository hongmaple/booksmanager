package com.common.servlet;

import com.common.dao.UsersDao;
import com.common.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
* ClassName:UsersServlet
* Description:
*/
@WebServlet(name = "UsersServlet",urlPatterns = "/UsersServlet")
public class UsersServlet extends HttpServlet {

    UsersDao usersDao = new UsersDao();

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
        }else if (request.getParameter("type").equals("get")){
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




    //添加Users信息
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password=request.getParameter("password");
        String address=request.getParameter("address");
        String gender=request.getParameter("gender");
        String name=request.getParameter("name");
        String phonenumber=request.getParameter("phonenumber");
        String type=request.getParameter("type1");

        Users obj=new Users();

        obj.setPassword(password);
        obj.setAddress(address);
        obj.setGender(gender);
        obj.setName(name);
        obj.setPhonenumber(phonenumber);
        obj.setType(type);

        usersDao.save(obj);//调用数据库添加
        response.sendRedirect("UsersServlet?type=query");
    }

    //修改Users信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password=request.getParameter("password");
        String address=request.getParameter("address");
        String gender=request.getParameter("gender");
        String name=request.getParameter("name");
        String phonenumber=request.getParameter("phonenumber");
        String id=request.getParameter("id");
        String type=request.getParameter("type1");

        Users obj=new Users();

        obj.setPassword(password);
        obj.setAddress(address);
        obj.setGender(gender);
        obj.setName(name);
        obj.setPhonenumber(phonenumber);
         obj.setId(Integer.parseInt(id));
        obj.setType(type);

        usersDao.update(obj); //调用数据库修改功能
        response.sendRedirect("UsersServlet?type=query");
    }


    //根据主键id删除Users信息 id是整数
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        usersDao.delete(id);//调用数据库删除
        response.sendRedirect("UsersServlet?type=query");
    }


    //Users查询数据库中的所有数据
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<Users>  usersList=usersDao.queryAll(); //调用数据库查询所有
        request.setAttribute("usersList",usersList);   //绑定接受参数
        request.getRequestDispatcher("usersList.jsp").forward(request,response);
    }


    //Users根据主键id查询数据
    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Users users=usersDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("users",users);   //绑定接受参数
        request.getRequestDispatcher("usersUpdate.jsp").forward(request,response);
    }

    //Users根据主键id查询数据 跳转到编辑页面
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Users users=usersDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("users",users);   //绑定接受参数
        request.getRequestDispatcher("usersUpdate.jsp").forward(request,response);
    }




}

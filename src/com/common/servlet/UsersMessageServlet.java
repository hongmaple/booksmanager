package com.common.servlet;

import com.common.dao.UsersMessageDao;
import com.common.entity.UsersMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersMessageSevlet",urlPatterns = "/UsersMessageSevlet")
public class UsersMessageServlet extends HttpServlet {

    UsersMessageDao usersMessageDao = new UsersMessageDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码集 防止接收参数乱码
        req.setCharacterEncoding("utf-8");
        // 设置响应格式为网页编码，编码为utf-8 防止输出乱码
        resp.setCharacterEncoding("utf-8");
        if (req.getParameter("type").equals("search")){
            searchList(req,resp);
        }
    }

    protected void searchList(HttpServletRequest request, HttpServletResponse response){
        List<UsersMessage> sysMsgs = usersMessageDao.searchList(Integer.parseInt(request.getParameter("userId")),request.getParameter("title"));
        request.setAttribute("sysMsgs",sysMsgs);   //绑定接受参数
        try {
            request.getRequestDispatcher("UsersMessageList.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

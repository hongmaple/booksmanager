package com.common.servlet;

import com.common.dao.MessageCenterDao;
import com.common.entity.SysMsg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 消息中心
 */
@WebServlet(name = "/MessageCenterSevlet",urlPatterns = "/MessageCenterSevlet")
public class MessageCenterSevlet extends HttpServlet {

    MessageCenterDao messageCenterDao = new MessageCenterDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码集 防止接收参数乱码
        req.setCharacterEncoding("utf-8");
        // 设置响应格式为网页编码，编码为utf-8 防止输出乱码
        resp.setCharacterEncoding("utf-8");
        if(req.getParameter("type").equals("save")){
            if (save(req,resp)){
                resp.setStatus(201);
                req.setAttribute("msg","新增成功");
                req.setAttribute("title",null);
                List<SysMsg> sysMsgs = messageCenterDao.searchList(null);
                req.setAttribute("sysMsgs",sysMsgs);   //绑定接受参数
                req.getRequestDispatcher("MessageCenterList.jsp").forward(req,resp);
            }else {
                resp.setStatus(500);
                req.setAttribute("msg","新增失败");
            }
        }else if (req.getParameter("type").equals("search")){
            searchList(req,resp);
        }
    }

    /**
     * 创建消息
     * @param request 请求
     * @param response 响应
     */
    protected Boolean save(HttpServletRequest request, HttpServletResponse response){
        SysMsg sysMsg = new SysMsg();
        sysMsg.setTitle(request.getParameter("title"));
        sysMsg.setContent(request.getParameter("content"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = request.getParameter("indateTime");
        try {
            sysMsg.setIndateTime(simpleDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return messageCenterDao.save(sysMsg)>0;
    }

    protected void searchList(HttpServletRequest request, HttpServletResponse response){
        List<SysMsg> sysMsgs = messageCenterDao.searchList(request.getParameter("title"));
        request.setAttribute("sysMsgs",sysMsgs);   //绑定接受参数
        try {
            request.getRequestDispatcher("MessageCenterList.jsp").forward(request,response);
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

package com.common.servlet;



import com.common.dao.UsersDao;
import com.common.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求编码集 防止接收参数乱码
		request.setCharacterEncoding("utf-8");
		// 设置响应格式为网页编码，编码为utf-8 防止输出乱码
		response.setContentType("text/html;charset=UTF-8");

		String name = request.getParameter("name");
		String password = request.getParameter("password");
//		String code = request.getParameter("code");

		// 获取session
		HttpSession session = request.getSession();
		// 获取验证码
//		String randCode = session.getAttribute("randCode").toString();

		// 判断输入验证码是否相等
//		if (!randCode.equals(code)) {
//			request.setAttribute("msg", "验证码错误");
//
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//			return;
//
//		}
		// 判断用户信息是否正确
		Users users = new UsersDao().queryByName(name);

//		Users users = usersDao.queryByname(name);
		if (null == users) {// 用户名不存在
			request.setAttribute("msg", "用户名不存在");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		// 判断密码正确
		// 将密码进行加密之后在进行比较
		// 将加密后的字符串和数据库比较 相等则登录成功
		// password= MD5Util.getMd5(password);
		System.out.println("password = " + password);
		if (!users.getPassword().equals(password)) {
			request.setAttribute("msg", "登录密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		// 登录成功
		// 登陆成功将用户信息放入session中 方便以后调用

		session.setAttribute("loginAdmin", users);
		response.sendRedirect("adminMain.jsp");
	}

}

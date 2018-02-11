package cn.bn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bn.pojo.User;
import cn.bn.send.SendEmail;


public class SendEmailServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//request.setCharacterEncoding("text/html;charset=UTF-8");
			String username=request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setUsername(username);
			//
			System.out.println("把用户信息注册到数据库中");
			System.out.println(email);
			SendEmail send = new SendEmail(user);
			send.start();
			request.setAttribute("message", "恭喜您，注册成功，我们已经发了一封带了注册信息的电子邮件，请查收，如果没有收到，可能是网络原因，过一会儿就收到了！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "注册失败！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

}

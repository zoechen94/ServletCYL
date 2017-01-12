package com.cn.yk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public void init(ServletConfig config)  throws ServletException{
    	 /**
          * 重写了Servlet的init方法后一定要记得调用父类的init方法，
          * 否则在service/doGet/doPost方法中使用getServletContext()方法获取ServletContext对象时
          * 就会出现java.lang.NullPointerException异常
          */
         super.init(config); 
         System.out.println("---loginServlet初始化开始---");
     }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try{
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Myfisrt</title>");
	        out.println("<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'></meta>");
			out.println("<link href='css/login.css' rel='stylesheet' type='text/css' />");
			out.println("<script src='js/jquery-1.11.1.min.js'></script>");
			out.println("<script src='js/login.js'></script>");
	        out.println("</head>");
			out.println("<body bgcolor=#CED2FF>");
			out.println("<h2>登录页面</h2>");
//			out.println("<form action='js/login.js'>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>姓名:<input type='text' class='username' placeholder='输入用户名' name='username' id='username'/></th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>密码：<input type='password' class='password' placeholder='输入密码' name='password' id='pass'/></th>");
			out.println("</tr>");
			out.println("<tr colspan=3>");
		    out.println("<th><input type=checkbox id='checkbox' name='keep' value='两个星期'>两个星期免登陆</input></th>");
			out.println("<th><input class='submit' type='submit' value='登录'></input></th>");
			out.println("<th><input type='reset' value='重置'></input></th>");
			out.println("</tr>");
//			out.println("</form>");
			out.println("</html>");
		}finally{
			out.close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
    public void destroy(){
    	super.destroy();
    	System.out.println("destroy------------loginservlet");
    }
}

package com.cn.yk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/maindetail")
public class MainDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
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
			out.println("<style>");
			out.println("p{color:blue}");
			out.println("</style>");
	        out.println("</head>");
			out.println("<body bgcolor=#CED2FF><center>");
			out.println("<div class='main' style='font-size:2em;>");
			out.println("<h2>主要菜单</h2>");
			out.println("<p><a href='billdetail'>查看账单</a></p>");
			out.println("<p><a href='serachUser'>查看用户</a></p>");
			out.println("<p><a>安全退出</a></p>");
			out.println("<p><a href='billdetail'>查看账单</a></p>");
			out.println("</div>");
			out.println("<center>"
					+ "</html>");
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

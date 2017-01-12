package com.cn.yk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/editbill")
public class EditBill extends HttpServlet {
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
			out.println("<script src='js/editbill.js'></script>");
	        out.println("</head>");
			out.println("<body bgcolor=#CED2FF>");
			out.println("<h2>更改账单页面</h2>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>账单号：<input type='text'  readonly='readonly' id='bill_id'/></th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>类型:<select id='type_id' ></select></th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>消费：<input type='text' class='text' id='xiaofei'/></th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>价格：<input type='text' class='text' id='price'/></th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>下单时间：<input type='text' class='text' id='time'/></th>");
			out.println("</tr>");
			out.println("<tr colspan=2>");
			out.println("<th><input class='submit' type='submit' value='提交'></input></th>");
			out.println("<th><input type='reset' value='重置'></input></th>");
			out.println("</tr>");
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

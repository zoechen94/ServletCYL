package com.cn.yk.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.yk.pojo.Bill;
import com.cn.yk.pojo.User;
import com.cn.yk.service.IBillDetailService;
import com.cn.yk.service.ILoginService;
import com.cn.yk.service.impl.BillDetailServiceImpl;
import com.cn.yk.service.impl.LoginServiceImpl;
import com.google.gson.Gson;

import jdk.internal.jfr.events.FileWriteEvent;

/**
 * Servlet implementation class QueryifLogin
 */
@WebServlet("/updatebill")
public class UpdateBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id=Integer.valueOf(request.getParameter("id"));
	    int type_id=Integer.valueOf(request.getParameter("type_id"));
	    String name=request.getParameter("name");
	    double price=Double.parseDouble(request.getParameter("price"));
	    Date date=new Date();
	    User user=(User) request.getSession().getAttribute("user");
	    int own_id=user.getId();
	    System.out.println("----------即将要改成------");
	    System.out.println("type_id:"+type_id+"|name:"+name+"|price:"+price+"date:"+date+"own_id:"+own_id);
	    IBillDetailService ib=new BillDetailServiceImpl();
	       boolean result=ib.updateBillById(id, type_id, name, price, date, own_id);
	    	Gson gson=new Gson();
	    	String jsonString = gson.toJson(result); 
	    	PrintWriter out=response.getWriter();
	    	out.print(jsonString);
	    	System.out.println("updatebill:"+jsonString);
	    
	}
}

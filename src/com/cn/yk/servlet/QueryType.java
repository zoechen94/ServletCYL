package com.cn.yk.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSpinnerUI;

import com.cn.yk.pojo.Bill;
import com.cn.yk.pojo.User;
import com.cn.yk.service.IBillDetailService;
import com.cn.yk.service.impl.BillDetailServiceImpl;
import com.google.gson.Gson;
import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/querytype")
public class QueryType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	            doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		IBillDetailService ib=new BillDetailServiceImpl();
		List list=ib.queryAllType();
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
    	String jsonString = gson.toJson(list); 
    	out.print(jsonString);
    	System.out.println(jsonString);
		
	}

}

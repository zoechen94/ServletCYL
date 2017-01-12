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
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthSpinnerUI;

import com.cn.yk.pojo.Bill;
import com.cn.yk.pojo.User;
import com.cn.yk.service.IBillDetailService;
import com.cn.yk.service.impl.BillDetailServiceImpl;
import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/deletebill")
public class Deletebill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("djfkdsjf");       
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		IBillDetailService ib=new BillDetailServiceImpl();
		PrintWriter out=response.getWriter();
		boolean result=ib.deleteById(id);
		if(result){
			//JOptionPane.showMessageDialog(null, "已经删除一条数据");
			System.out.println("已经删除一条数据");
		}else{
			//JOptionPane.showMessageDialog(null, "删除失败");
			System.out.println("删除失败");
		}
		response.sendRedirect("billdetail");
	}

}

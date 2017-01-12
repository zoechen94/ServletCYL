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
import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/billdetail")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public void init(ServletConfig config)  throws ServletException{
    	 /**
          * 重写了Servlet的init方法后一定要记得调用父类的init方法，
          * 否则在service/doGet/doPost方法中使用getServletContext()方法获取ServletContext对象时
          * 就会出现java.lang.NullPointerException异常
          */
         super.init(config); 
         System.out.println("---billservlet初始化开始---");
     } 
	 public void destroy(){
	    	super.destroy();
	    	System.out.println("destroy------------billservlet");
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	            doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		IBillDetailService ib=new BillDetailServiceImpl();
		PrintWriter out=response.getWriter();
		User u=(User)request.getSession().getAttribute("user");
		if(u==null){
			Cookie[] cookies = request.getCookies();  
			String na="";
	    	String pa="";
			// 然后迭代之 
		System.out.println();
			if (cookies != null) { //如果没有设置过Cookie会返回null  
				  for (int i=0;i<cookies.length;i++) {
				    	Cookie c=cookies[i];
				    	if(c.getName().equals("username")){
				    		na=c.getValue();
				    	} if(c.getName().equals("password")){
				    		pa=c.getValue();
				    	}
				    	if(!na.equals("")&&!pa.equals("")){
				    		response.sendRedirect("querylogin?username="+na+"&password="+pa);
				    		return;
				    	}
				     }
			}
		
		  response.sendRedirect("LoginServlet");
		  return ;
		}
		int own_id=u.getId();
		int current_page=1;
		int pageSize=4;
		int pageNumber;
		int count;
		int mohucount;
		int visitor= Integer.valueOf(this.getServletContext().getAttribute("visitor").toString());
		//读取客户
		try{
			String ccc=request.getParameter("current");
			System.out.println("------getcurrent-----"+ccc);
			current_page=Integer.parseInt(ccc);
		}catch (Exception e){
			System.err.println("错了错了错了");
		}
		String check="";
		try {
			check = request.getParameter("check");
		} catch (Exception e) {
			e.printStackTrace();
		}
		List list;
		if(check==null){//如果是空的，就是不做模糊查询
		       System.err.println("这是空的check");
		       count=ib.queryAll(own_id);
		       list=ib.queryByOwnid(own_id, current_page, pageSize);
		       System.out.println("own_id:"+own_id+"|count:"+count);
				if(count%pageSize==0){
					pageNumber=count/pageSize;
				}else{
					pageNumber=count/pageSize+1;
				}
				System.out.println("总共："+pageNumber+"页");
		 }else{
			  mohucount=ib.mohuqueryAll(own_id, check);
			  System.out.println("模糊查询的数量"+mohucount);
			  if(mohucount%pageSize==0){
				  pageNumber=mohucount/pageSize;
			  }else{
				  pageNumber=mohucount/pageSize+1;
			  }
			  list=ib.mohuqueryByOwnid(own_id, current_page, pageSize, check);
		 }
		
		System.out.println("-------current-page:"+current_page+"-----");
		  if(current_page!=1){
	    	  out.println("<a href='billdetail?current="+(current_page-1)+"'>上一页</a>");
	    }else{
	    	current_page=1;
	    }
	    if(current_page!=pageNumber){
	    	  out.println("<a href='billdetail?current="+(current_page+1)+"'>下一页</a>");
	    }
	    System.out.println("-------结束----------");	
		out.println("<form action=billdetail>");
		out.println("<input type=text name=current></input>");
		out.println("<input type=submit value=跳转>");
		out.println("</form>");
		out.println("<form action=billdetail>");
		out.println("<input type=text name='check'>");
		out.println("<input style='display:none'type=text name='current' value='"+current_page+"'>");
		out.println("<input type=submit value=模糊查询>");
		out.println("</form>");
		try{
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Myfisrt</title>");
	        out.println("<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'></meta>");
	        out.println("<link href='css/login.css' rel='stylesheet' type='text/css' /></meta>");
	        out.println("<linkhref='skins/default.css' rel='stylesheet' type='text/css'/>");
	        out.println("<script src='js/jquery-1.11.1.min.js'></script>");
            out.println("<script type='text/JavaScript' src='js/artDialog.js'></script>");
            out.println("<script type='text/javascript' src='js/jquery.artDialog.js'></script>");
            out.println("<script type='text/javascript' src='js/billoperate.js'></script>");
	        out.println("</head>");
			out.println("<body>");
			out.println("<h2>账单详情</h2>");
			out.println("<h4>"+u.getUsername()+"您好，您是第"+visitor+"位访问者</h4>");
			out.println("<table  border=1 class='tab'>");
			out.println("<tr bgcolor=#E8F2FE>");
			out.println("<th >账单号</th><th>类型</th><th>消费</th><th>价格</th><th>下单时间</th><th>删除</th><th>修改</th>");
			String [] colors={"#F0F0F0","#4DAC81"};
			for(int i=0;i<list.size();i++){
				Bill bill=(Bill) list.get(i);
				String name=java.net.URLDecoder.decode(bill.getName(), "UTF-8");
				out.println("<tr bgcolor="+colors[i%2]+">");
				out.println("<td>"+bill.getId()+"</td>");
				out.println("<td>"+bill.getType_name()+"</td>");
				out.println("<td>"+bill.getName()+"</td>");
				out.println("<td>"+bill.getPrice()+"</td>");
				out.println("<td>"+bill.getOrder_time()+"</td>");
				out.println("<td><a id=xx href='deletebill?id="+bill.getId()+"' >删除</a></td>");
				out.println("<td><a href='editbill?id="+bill.getId()+"&type_id="+bill.getType_id()+"&price="+bill.getPrice()+"&name="+name+"&time="+bill.getOrder_time()+"'>修改</a></td>");
				out.println("</tr>");
			}
			for(int i=1;i<=pageNumber;i++){
				out.print("<a href='billdetail?current="+i+"'>第"+i+"页</a>");
			}
			out.println("</html>");
		}finally{
			out.close();
		}     
	}

}

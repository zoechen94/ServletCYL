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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.yk.pojo.User;
import com.cn.yk.service.ILoginService;
import com.cn.yk.service.impl.LoginServiceImpl;
import com.google.gson.Gson;

import jdk.internal.jfr.events.FileWriteEvent;

/**
 * Servlet implementation class QueryifLogin
 */
@WebServlet("/querylogin")
public class QueryifLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public void init(ServletConfig config)  throws ServletException{
    	 /**
          * 重写了Servlet的init方法后一定要记得调用父类的init方法，
          * 否则在service/doGet/doPost方法中使用getServletContext()方法获取ServletContext对象时
          * 就会出现java.lang.NullPointerException异常
          */
         super.init(config); 
         System.out.println("---querylogin初始化开始---");
         File file=new File("f:/","number.txt");
 	    
 		if(file.exists()){
 			System.out.println("文件已经存在");
 			try {  
 	          //   读取文件内容 (输入流) 
 			    	FileInputStream fi = new FileInputStream(file);  
 		    		String line; // 用来保存每行读取的内容 
 		    		BufferedReader bufferreader = new BufferedReader(new InputStreamReader( 
 		    		fi)); 
 		    		line = bufferreader.readLine(); // 读取第一行 
 		    		if(line!=null){
 		    			System.out.println("读取的第一行："+line);
		    			int num=Integer.valueOf(line);
		    			this.getServletContext().setAttribute("visitor",num+"");
                      //开始写
 		    			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file));
	    		            BufferedWriter bw = new BufferedWriter(write);
	    		            bw.write(num);
	    		            bw.flush();  
	    		            write.close();
	    		            bw.close();
 		    		}
 				 
 	        } catch (Exception e) {  
 	           e.printStackTrace();
 	        }  
 		}else{
 			try{
 			    file.createNewFile();//创建
 			    // 向文件写入内容(输出流)  
 		        String number="0";
 		        this.getServletContext().setAttribute("visitor","0");
 		        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file));
 		            BufferedWriter bw = new BufferedWriter(write);
 		            bw.write(number);
 		            bw.flush();  
 		            write.close();
 		            bw.close();
			     } catch (Exception e) {
				    e.printStackTrace();
			     }
 		}
 		System.out.println("---querylogin初始化结束---");
     }
	 public void destroy(){
	    	System.out.println("destroy------------queryservlet");
	    	
	    	 File file=new File("f:/","number.txt");
		      String number=this.getServletContext().getAttribute("visitor").toString();
		      try{
	 		        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file));
	 		            BufferedWriter bw = new BufferedWriter(write);
	 		            bw.write(number);
	 		            bw.flush();  
	 		            write.close();
	 		            bw.close();
				     } catch (Exception e) {
					    e.printStackTrace();
				     }
	    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    String checkbox=request.getParameter("checkbox");
	    
	 System.out.println("user:"+username+"|pass22:"+password+"|checkbox"+checkbox);
	    ILoginService ls=new LoginServiceImpl();
	    User u=new User();
	    u=ls.queryUser(username, password);
	    if(u!=null){
	    	if(checkbox!=null){
	    		System.out.println("checkbox:"+checkbox);
	         	Cookie cookiename=new Cookie("username",username);
	    	    Cookie cookiepassword=new Cookie("password",password);
	    	       cookiename.setMaxAge(1*24*60*60); 
	    	       cookiepassword.setMaxAge(1*24*60*60);
	    	       response.addCookie(cookiename);
	    	       response.addCookie(cookiepassword);
	    	}
	        int times=Integer.valueOf(this.getServletContext().getAttribute("visitor").toString())+1;
	        this.getServletContext().setAttribute("visitor",times+"");
	    	request.getSession().setAttribute("user", u);
	    	System.out.println("u.id:"+u.getId());
	    	Gson gson=new Gson();
	    	String jsonString = gson.toJson(u); 
	    	PrintWriter out=response.getWriter();
	    	out.print(jsonString);
	    	System.out.println(jsonString);
	    }
	}
}

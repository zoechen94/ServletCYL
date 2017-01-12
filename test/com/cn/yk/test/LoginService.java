package com.cn.yk.test;

import javax.servlet.http.HttpServletRequest;

import com.cn.yk.pojo.User;
import com.cn.yk.service.ILoginService;
import com.cn.yk.service.impl.LoginServiceImpl;

public class LoginService {
         public static void main(String[] args) {
        	HttpServletRequest resp = null;
			ILoginService is=new LoginServiceImpl();
			User user=is.queryUser("³ÂÑÇÀ¼ ","chenyalan");
			if(user!=null){
				System.out.println();
				System.out.println("user:"+user.getUsername()+"|age:"+user.getAge());
			}
		}
}

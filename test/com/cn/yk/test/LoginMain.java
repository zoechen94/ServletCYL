package com.cn.yk.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.yk.pojo.User;
import com.cn.yk.service.ILoginService;
import com.cn.yk.service.impl.LoginServiceImpl;

public class LoginMain {
	    @Autowired
	    @Qualifier("loginservice")
	    private static ILoginService loginService;
   public static void main(String[] args) {
		 ApplicationContext 
		 context = new ClassPathXmlApplicationContext("/applicationContext.xml"); 
	    User user=(User) loginService.queryUser("³ÂÑÇÀ¼", "chenyalan");
	    System.out.println("user.name:"+user.getUsername());
}
}

package com.cn.yk.service.impl;

import com.cn.yk.dao.ILoginDao;
import com.cn.yk.dao.impl.LoginDaoImpl;
import com.cn.yk.pojo.User;
import com.cn.yk.service.ILoginService;

public class LoginServiceImpl implements ILoginService {
	ILoginDao logindao=new LoginDaoImpl();
	@Override
	public User queryUser(String username, String password) {
		return logindao.queryUser(username, password);
	}

}

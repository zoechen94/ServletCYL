package com.cn.yk.test;

import com.cn.yk.db.DBUtil;
import com.cn.yk.pojo.User;

public class DBUtilTest {
	public static void main(String[] args) {
		//能够获取到链接对象
		System.out.println(DBUtil.getConnection());
		//测试一下查询
		System.out.println(DBUtil.executeQuery("select name from t_user where id=1"));
		//测试修改
		String sql="select name,pass,age from t_user where id=1";
	}}

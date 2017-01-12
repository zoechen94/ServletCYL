package com.cn.yk.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.yk.dao.ILoginDao;
import com.cn.yk.db.DBUtil;
import com.cn.yk.db.IResultSetUtil;
import com.cn.yk.pojo.User;
public class LoginDaoImpl implements ILoginDao {
	public User queryUser(String username, String password) {
      String sql="select id,name,pass,age,tele from t_user where name=? and pass=?";
      User u=(User) DBUtil.executeQuery(sql,new IResultSetUtil() {
		public Object doHandler(ResultSet rs) throws SQLException {
			User user=new User();
			 if(rs.next()){
			        user.setId(rs.getInt(1));
			        user.setUsername(rs.getString(2));
			        user.setPassword(rs.getString(3));
			        user.setAge(rs.getInt(4));
			        user.setTele(rs.getString(5));
			    }
			return user;
		}
	},username,password);
      return u;
	}
}

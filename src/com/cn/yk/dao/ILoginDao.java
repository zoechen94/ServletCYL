package com.cn.yk.dao;

import com.cn.yk.pojo.User;

public interface ILoginDao {
public User queryUser(String username,String password);
}

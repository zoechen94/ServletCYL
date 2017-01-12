package com.cn.yk.service;

import org.springframework.stereotype.Service;

import com.cn.yk.pojo.User;
public interface ILoginService {
public User queryUser(String username,String password);
}

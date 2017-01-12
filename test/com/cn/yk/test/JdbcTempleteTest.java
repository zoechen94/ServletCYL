package com.cn.yk.test;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class JdbcTempleteTest {
	/**
     * 使用spring jdbctemplate添加数据
     */
    @Test
    public void testJdbcTemplate(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbctemplate");
        String sql = "INSERT INTO t_user(name,pass,age,tele) VALUES('yes','yes',13,'1548597349')";
        jdbcTemplate.execute(sql);
    }
}

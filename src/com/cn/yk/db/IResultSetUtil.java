package com.cn.yk.db;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 处理ResultSet的接口
 * @author CYL
 *
 */
public interface IResultSetUtil {
	public Object doHandler(ResultSet rs) throws SQLException;
}

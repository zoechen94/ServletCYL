package com.cn.yk.db;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class ConnectionManager {
	private static ConnectionManager instance;
	//C3P0µÄÁ¬½Ó³Ø¶ÔÏó
	private ComboPooledDataSource ds;
	private ConnectionManager() throws Exception{
		ds=new ComboPooledDataSource("mysql");
	}
	/**
	 * µ¥ÀýÄ£Ê½»ñÈ¡Êý¾Ý¿âÁ¬½Ó¶ÔÏó
	 */
	public static final ConnectionManager getInstance(){
		if(instance==null){
			try {
				instance=new ConnectionManager();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	/**
	 * ÎªÁËÏß³Ì°²È«£¬Í¬²½
	 * @return
	 */
	public synchronized final Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (Exception e) {
            e.printStackTrace();
		}
		return null;
	}
	@Override
	protected void finalize() throws Throwable {
		DataSources.destroy(ds);//¹Ø±ÕDataSource
		super.finalize();
	}
	
}

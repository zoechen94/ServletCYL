package com.cn.yk.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cn.yk.dao.IBillDetail;
import com.cn.yk.db.DBUtil;
import com.cn.yk.db.IResultSetUtil;
import com.cn.yk.pojo.Bill;
import com.cn.yk.pojo.Type;

public class BillDetailDaoImpl implements IBillDetail {

	@Override
	public List queryByOwnid(int own_id,int current_page,int pageSize)  {
		String sql="SELECT b.id,type_name as '类型名字',name as '消费',price as '价格',order_time as '下单时间',b.type_id from bill as b,type as t where b.own_id=? and b.type_id=t.id limit ?,?";
	    int start=(current_page-1)*pageSize;
		List list=(List) DBUtil.executeQuery(sql, new IResultSetUtil() {
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List ll=new ArrayList();
				while(rs.next()){
					Bill bill=new Bill();
					bill.setId(rs.getInt(1));
					bill.setType_name(rs.getString(2));
					bill.setName(rs.getString(3));
					bill.setPrice(rs.getDouble(4));
					bill.setOrder_time(rs.getString(5));
					bill.setType_id(rs.getInt(6));
					ll.add(bill);
				}
				return ll;
			}
		},own_id,start,pageSize);
	    return list;
	}

	@Override
	public int queryAll(int own_id) {
		String sql=" SELECT COUNT(*) FROM bill where own_id=? ";
	     int count=(int) DBUtil.executeQuery(sql, new IResultSetUtil() {
			public Object doHandler(ResultSet rs) throws SQLException {
                 int c=0;
				if(rs.next()){
					 c=rs.getInt(1);
				 }
				return c;
			}
		},own_id);
	    return count;
	}

	@Override
	public boolean deleteById(int id) {
	String sql="DELETE from bill where id=?";
	 int count=DBUtil.executeUpdate(sql, id);
	 if(count>0){
		 return true;
	 }else{
		 return false;
	 }
	}

	@Override
	public List queryAllType() {
		String sql="SELECT id,type_name from type";
		List list=(List) DBUtil.executeQuery(sql, new IResultSetUtil() {
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List ll=new ArrayList();
				while(rs.next()){
					Type type=new Type();
					type.setId(rs.getInt(1));
					type.setName(rs.getString(2));
					ll.add(type);
				}
				return ll;
			}
		});
		return list;
	}

	@Override
	public boolean updateBillById(int id, int type_id, String name, double price, Date date, int own_id) {
		String sql="update bill set type_id=?,name=?,price=?,order_time=?,own_id=? where id=?";
		int count;
		count=DBUtil.executeUpdate(sql, type_id,name,price,date,own_id,id);
		if(count>0){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List mohuqueryByOwnid(int own_id, int current_page, int pageSize, String check) {
		String sql="select * from"
				+ " (SELECT b.id,type_name as '类型名字',name as '消费',price as '价格',order_time as '下单时间',b.type_id"
				+ " from bill as b,type as t where b.own_id=? and b.type_id=t.id ) as c "
				+ " where c.id like '%"+check+"%' or c.type_id like '%"+check+"%' or c.`消费` like '%"+check+"%' or c.`价格` like '%"+check+"%'"
				+ " LIMIT ?,?";
	    int start=(current_page-1)*pageSize;
		List list=(List) DBUtil.executeQuery(sql, new IResultSetUtil() {
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List ll=new ArrayList();
				while(rs.next()){
					Bill bill=new Bill();
					bill.setId(rs.getInt(1));
					bill.setType_name(rs.getString(2));
					bill.setName(rs.getString(3));
					bill.setPrice(rs.getDouble(4));
					bill.setOrder_time(rs.getString(5));
					bill.setType_id(rs.getInt(6));
					ll.add(bill);
				}
				return ll;
			}
		},own_id,start,pageSize);
	    return list;
	}

	@Override
	public int mohuqueryAll(int own_id,String check) {
		String sql="select count(*) from"
				+ " (SELECT b.id,type_name as '类型名字',name as '消费',price as '价格',order_time as '下单时间',b.type_id"
				+ " from bill as b,type as t where b.own_id=? and b.type_id=t.id ) as c "
				+ " where c.id like '%"+check+"%' or c.type_id like '%"+check+"%' or c.`消费` like '%"+check+"%' or c.`价格` like '%"+check+"%'";
		int count=(int) DBUtil.executeQuery(sql, new IResultSetUtil() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				int c=0;
				if(rs.next()){
					c=rs.getInt(1);
				}
				return c;
			}
		}, own_id);
		System.out.println("模糊查询里的count:"+count);
		return count;
	}


}

package com.cn.yk.service.impl;

import java.util.Date;
import java.util.List;

import com.cn.yk.dao.IBillDetail;
import com.cn.yk.dao.impl.BillDetailDaoImpl;
import com.cn.yk.service.IBillDetailService;

public class BillDetailServiceImpl implements IBillDetailService{
	   IBillDetail ib=new BillDetailDaoImpl();
	public List queryByOwnid(int own_id, int current_page, int pageSize) {
	       return ib.queryByOwnid(own_id, current_page, pageSize);
	}
	@Override
	public int queryAll(int own_id) {
           return ib.queryAll(own_id);
	}
	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return ib.deleteById(id);
	}
	@Override
	public List queryAllType() {
		// TODO Auto-generated method stub
		return ib.queryAllType();
	}
	@Override
	public boolean updateBillById(int id, int type_id, String name, double price, Date date, int own_id) {
		return ib.updateBillById(id, type_id, name, price, date, own_id);
	}
	@Override
	public List mohuqueryByOwnid(int own_id, int current_page, int pageSize, String check) {
		// TODO Auto-generated method stub
		return ib.mohuqueryByOwnid(own_id, current_page, pageSize, check);
	}
	@Override
	public int mohuqueryAll(int own_id, String check) {
		return ib.mohuqueryAll(own_id, check);
	}

}

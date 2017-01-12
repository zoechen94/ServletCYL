package com.cn.yk.test;

import java.util.ArrayList;
import java.util.List;

import com.cn.yk.pojo.Bill;
import com.cn.yk.service.IBillDetailService;
import com.cn.yk.service.impl.BillDetailServiceImpl;

public class BillDetailTest {
public static void main(String[] args) {
	List list=new ArrayList();
	IBillDetailService ib=new BillDetailServiceImpl();
	int own_id=2;
	int current_page=4;
	int pageSize=4;
	list=ib.queryByOwnid(own_id, current_page, pageSize);
	for(int i=0;i<list.size();i++){
		Bill bill=(Bill) list.get(i);
		System.out.println("bill-id:"+bill.getId()+"|name:"+bill.getName()+"type-name:"+bill.getType_name()+"order_time:"+bill.getOrder_time());
	}
}
}

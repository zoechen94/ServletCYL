package com.cn.yk.service;

import java.util.Date;
import java.util.List;

public interface IBillDetailService {
public List queryByOwnid(int own_id,int current_page,int pageSize);
public int queryAll(int own_id);
public boolean deleteById(int id);
public List queryAllType();
public boolean updateBillById(int id,int type_id,String name,double price,Date date,int own_id);
public int mohuqueryAll(int own_id,String check);
public List mohuqueryByOwnid(int own_id,int current_page,int pageSize,String check);
}

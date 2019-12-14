package com.biz;

import java.util.List;

import com.po.orderform;
import com.po.pagebean;


public interface IorderformBiz {
	//订单（增查）
	public  boolean   save(orderform  om);
	public  boolean   update(orderform  om);
	public  boolean   delbyid(Integer ormid);
	public  orderform   findbyiid(Integer ordid);
	public  List<orderform>   findbyid(Integer regid);
	public  List<orderform>   findall(pagebean pb);
	public  int   findmaxrows();
}

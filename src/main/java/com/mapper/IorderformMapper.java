package com.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.po.collect;
import com.po.orderform;
import com.po.pagebean;

@Service("orderformdao")
public interface IorderformMapper {
	//订单（增查）
	public  int   save(orderform  om);
	public  int   update(orderform  om);
	public  int   delbyid(Integer ordid);
	public  int   delbyiid(Integer regid);
	public  orderform   findbyiid(Integer ordid);
	public  List<orderform>   findbyid(Integer regid);
	public  List<orderform>   findall(pagebean pb);
	public  int   findmaxrows();
}

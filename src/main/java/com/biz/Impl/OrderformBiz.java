package com.biz.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.biz.IorderformBiz;
import com.po.orderform;
import com.po.pagebean;
import com.service.DaoService;
@Service("OrderforBiz")
public class OrderformBiz implements IorderformBiz {
	@Resource(name="daoservice")
    private   DaoService  daoservice;
    
	public DaoService getDaoservice() {
		return daoservice;
	}

	public void setDaoservice(DaoService daoservice) {
		this.daoservice = daoservice;
	}
	@Override
	public boolean save(orderform om) {
		int  code=daoservice.getOrderformmapper().save(om);
		if (code>0) {
			return  true;
		}
		return false;
	}

	@Override
	public boolean update(orderform om) {
		int  code=daoservice.getOrderformmapper().update(om);
		if (code>0) {
			return  true;
		}
		return false;
	}

	@Override
	public boolean delbyid(Integer ordid) {
		int  code=daoservice.getOrderformmapper().delbyid(ordid);
		if (code>0) {
			return  true;
		}
		return false;
	}
	@Override
	public List<orderform> findbyid(Integer regid) {
		// TODO Auto-generated method stub
		return daoservice.getOrderformmapper().findbyid(regid);
	}

	@Override
	public List<orderform> findall(pagebean pb) {
		if (pb==null) {
			new  pagebean();
		}
		return daoservice.getOrderformmapper().findall(pb);
	}

	@Override
	public int findmaxrows() {
		// TODO Auto-generated method stub
		return daoservice.getOrderformmapper().findmaxrows();
	}

	@Override
	public orderform findbyiid(Integer ordid) {
		
		return daoservice.getOrderformmapper().findbyiid(ordid);
	}


}

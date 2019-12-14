package com.biz.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.biz.IregisterBiz;
import com.po.pagebean;
import com.po.register;
import com.service.DaoService;
@Service("RegisterBiz")
public class RegisterBiz implements IregisterBiz {
	  @Resource(name="daoservice")
    private   DaoService  daoservice;
    
	public DaoService getDaoservice() {
		return daoservice;
	}

	public void setDaoservice(DaoService daoservice) {
		this.daoservice = daoservice;
	}

	@Override
	public boolean save(register rt) {
		int  code=daoservice.getRegistermapper().save(rt);
		if (code>0) {
			return  true;
		}
		return false;
	}

	@Override
	public boolean update(register rt) {
		int  code=daoservice.getRegistermapper().update(rt);
		if (code>0) {
			return  true;
		}
		return false;
	}

	@Override
	public boolean delbyid(String   iid) {
		register  rt=daoservice.getRegistermapper().findbyiid(iid);
		daoservice.getOrderformmapper().delbyiid(rt.getRegid());
		daoservice.getCollectmapper().delbyiid(rt.getRegid());
		int  code=daoservice.getRegistermapper().delbyid(iid);
		System.out.println(code);
		if (code>0) {
			return  true;
		}
		return false;
	}
	
	@Override
	public boolean delbyreg(Integer regid) {
		daoservice.getOrderformmapper().delbyid(regid);
		daoservice.getCollectmapper().delbyid(regid);
		int  code=daoservice.getRegistermapper().delbyreg(regid);
		if (code>0) {
			return  true;
		}
		return false;
	}
	
	@Override
	public register findbyid(Integer regid) {

		return daoservice.getRegistermapper().findbyid(regid);
	}
	

	@Override
	public register findbyiid(String iid) {
		return daoservice.getRegistermapper().findbyiid(iid);
	}
	@Override
	public List<register> findall(pagebean  pb) {
		
		return daoservice.getRegistermapper().findall(pb);
	}

	@Override
	public int findmaxrows() {
		
		return daoservice.getRegistermapper().findmaxrows();
	}

	@Override
	public List<register> findalll() {
		
		return daoservice.getRegistermapper().findalll();
	}


}

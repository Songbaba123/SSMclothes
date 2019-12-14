package com.biz.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.biz.IclothesBiz;
import com.po.clothes;
import com.po.pagebean;
import com.service.DaoService;
@Service("ClothesBiz")
public class ClothesBiz implements IclothesBiz {
	@Resource(name="daoservice")
    private   DaoService  daoservice;
	
	public DaoService getDaoservice() {
		return daoservice;
	}

	public void setDaoservice(DaoService daoservice) {
		this.daoservice = daoservice;
	}

	@Override
	public boolean save(clothes cs) {
		int  code=daoservice.getClothesmapper().save(cs);
		if (code>0) {
			return  true;
		}
		return false;
	}

	@Override
	public boolean update(clothes cs) {
		int  code=daoservice.getClothesmapper().update(cs);
		if (code>0) {
			return  true;
		}
		return false;
	}

	@Override
	public boolean delbyid(Integer clid) {
		int  code=daoservice.getClothesmapper().delbyid(clid);
		if (code>0) {
			return  true;
		}
		return false;
	}

	@Override
	public clothes findbyid(Integer clid) {
		
		return daoservice.getClothesmapper().findbyid(clid);
	}

	@Override
	public List<clothes> findall(pagebean pb) {
		if (pb==null) {
			new  pagebean();
		}
		return daoservice.getClothesmapper().findall(pb);
	}

	@Override
	public int findmaxrows() {
		return daoservice.getClothesmapper().findmaxrows();
	}

}

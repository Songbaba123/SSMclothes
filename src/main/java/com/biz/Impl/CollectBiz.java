package com.biz.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.biz.IcollectBiz;
import com.po.collect;
import com.po.pagebean;
import com.service.DaoService;
@Service("CollectBiz")
public class CollectBiz implements IcollectBiz {
    @Resource(name="daoservice")
    private   DaoService  daoservice;
    
	public DaoService getDaoservice() {
		return daoservice;
	}

	public void setDaoservice(DaoService daoservice) {
		this.daoservice = daoservice;
	}

	@Override
	public boolean save(collect ct) {
		int code=daoservice.getCollectmapper().save(ct);
		if (code>0) {
			return  true;
		}
		return false;
	}

	@Override
	public boolean update(collect ct) {
		int code=daoservice.getCollectmapper().update(ct);
		if (code>0) {
			return  true;
		}
		return false;
	}

	@Override
	public boolean delbyid(Integer coid) {
		int code=daoservice.getCollectmapper().delbyid(coid);
		if (code>0) {
			return  true;
		}
		return false;
	}

	@Override
	public collect findbyid(Integer coid) {
		// TODO Auto-generated method stub
		return daoservice.getCollectmapper().findbyid(coid);
	}

	@Override
	public List<collect> findall(Integer  regid) {
		
		return daoservice.getCollectmapper().findall(regid);
	}

	@Override
	public int findamaxrows() {
		// TODO Auto-generated method stub
		return daoservice.getCollectmapper().findamaxrows();
	}

}

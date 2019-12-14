package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.*;

@Service("daoservice")
public class DaoService {
	@Resource(name="collectdao")
   private   IcollectMapper   collectmapper;
	@Resource(name="clothesdao")
	   private   IclothesMapper   clothesmapper;
	@Resource(name="orderformdao")
	   private   IorderformMapper   orderformmapper;
	@Resource(name="registerdao")
	   private   IregisterMapper   registermapper;
	public IcollectMapper getCollectmapper() {
		return collectmapper;
	}
	public void setCollectmapper(IcollectMapper collectmapper) {
		this.collectmapper = collectmapper;
	}
	public IclothesMapper getClothesmapper() {
		return clothesmapper;
	}
	public void setClothesmapper(IclothesMapper clothesmapper) {
		this.clothesmapper = clothesmapper;
	}
	public IorderformMapper getOrderformmapper() {
		return orderformmapper;
	}
	public void setOrderformmapper(IorderformMapper orderformmapper) {
		this.orderformmapper = orderformmapper;
	}
	public IregisterMapper getRegistermapper() {
		return registermapper;
	}
	public void setRegistermapper(IregisterMapper registermapper) {
		this.registermapper = registermapper;
	}
	
	
}

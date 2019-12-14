package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.biz.Impl.*;
@Service("bizservice")
public class BizService {
	@Resource(name="CollectBiz")
	   private   CollectBiz    collectbiz ;
		@Resource(name="ClothesBiz")
		   private    ClothesBiz    clothesbiz ;
		@Resource(name="OrderforBiz")
		   private    OrderformBiz    orderformbiz ;
		@Resource(name="RegisterBiz")
		   private    RegisterBiz    registerbiz ;
		public CollectBiz getCollectbiz() {
			return collectbiz;
		}
		public void setCollectbiz(CollectBiz collectbiz) {
			this.collectbiz = collectbiz;
		}
		public ClothesBiz getClothesbiz() {
			return clothesbiz;
		}
		public void setClothesbiz(ClothesBiz clothesbiz) {
			this.clothesbiz = clothesbiz;
		}
		public OrderformBiz getOrderformbiz() {
			return orderformbiz;
		}
		public void setOrderformbiz(OrderformBiz orderformbiz) {
			this.orderformbiz = orderformbiz;
		}
		public RegisterBiz getRegisterbiz() {
			return registerbiz;
		}
		public void setRegisterbiz(RegisterBiz registerbiz) {
			this.registerbiz = registerbiz;
		}
		
		
}

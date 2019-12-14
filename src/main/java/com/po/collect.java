package com.po;

import java.io.Serializable;

public class collect implements Serializable{
	  //收货表
    private   Integer   coid;//收货编号
    private   String    sname;//收货人姓名
    private   String    phonenumber;//收货手机号
    private   String    address;//收货地址
    private   Integer   regid;//关联的账号
	public collect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public collect(Integer coid, String sname, String phonenumber, String address, Integer regid) {
		super();
		this.coid = coid;
		this.sname = sname;
		this.phonenumber = phonenumber;
		this.address = address;
		this.regid = regid;
	}
	public Integer getCoid() {
		return coid;
	}
	public void setCoid(Integer coid) {
		this.coid = coid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getRegid() {
		return regid;
	}
	public void setRegid(Integer regid) {
		this.regid = regid;
	}
	@Override
	public String toString() {
		return "collect [coid=" + coid + ", sname=" + sname + ", phonenumber=" + phonenumber + ", address=" + address
				+ ", regid=" + regid + "]";
	}
    
    
}

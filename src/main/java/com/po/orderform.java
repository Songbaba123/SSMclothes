package com.po;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class orderform implements Serializable{
	//订单表
     private   Integer   ordid;//订单 编号
     private   Integer   clid;//服装编号
     private   Integer   regid;//关联的账号
     private   Integer   coid;//地址信息编号
     
     private   String  clothesname;
     private   String  photo;
     private   String  size;
     private   Float  price;
     private   String  sname;
     private   String phonenumber;
     private   String address;
	public orderform() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderform(Integer ordid, Integer clid, Integer regid, Integer coid) {
		super();
		this.ordid = ordid;
		this.clid = clid;
		this.regid = regid;
		this.coid = coid;
	}
	
	public orderform(Integer regid, String clothesname, String photo, String size, Float price, String sname,
			String phonenumber, String address) {
		super();
		this.regid = regid;
		this.clothesname = clothesname;
		this.photo = photo;
		this.size = size;
		this.price = price;
		this.sname = sname;
		this.phonenumber = phonenumber;
		this.address = address;
	}
	public Integer getOrdid() {
		return ordid;
	}
	public void setOrdid(Integer ordid) {
		this.ordid = ordid;
	}
	public Integer getClid() {
		return clid;
	}
	public void setClid(Integer clid) {
		this.clid = clid;
	}
	public Integer getRegid() {
		return regid;
	}
	public void setRegid(Integer regid) {
		this.regid = regid;
	}
	public Integer getCoid() {
		return coid;
	}
	public void setCoid(Integer coid) {
		this.coid = coid;
	}
	public String getClothesname() {
		return clothesname;
	}
	public void setClothesname(String clothesname) {
		this.clothesname = clothesname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
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
	@Override
	public String toString() {
		return "orderform [ordid=" + ordid + ", clid=" + clid + ", regid=" + regid + ", coid=" + coid + "]";
	}
	 
    
     
     
}

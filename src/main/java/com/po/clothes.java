package com.po;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class clothes implements Serializable{
	  //服装表
     private   Integer  clid; //服装编号
     private   String   clothesname; //服装名称
     private   String   photo="default.jpg"; //服装图片
     private   String  size; //服装尺码
     private   Float    price; //服装价格
     private   Integer  stock; //服装库存
     private MultipartFile pic;
	public clothes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public clothes(String clothesname, String photo, String size, Float price, Integer stock) {
		super();
		this.clothesname = clothesname;
		this.photo = photo;
		this.size = size;
		this.price = price;
		this.stock = stock;
	}
	public clothes(Integer clid, String clothesname, String size, Float price, Integer stock, MultipartFile pic) {
		super();
		this.clid = clid;
		this.clothesname = clothesname;
		this.size = size;
		this.price = price;
		this.stock = stock;
		this.pic = pic;
	}
	public Integer getClid() {
		return clid;
	}
	public void setClid(Integer clid) {
		this.clid = clid;
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
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public MultipartFile getPic() {
		return pic;
	}
	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "clothes [clid=" + clid + ", clothesname=" + clothesname + ", photo=" + photo + ", size=" + size
				+ ", price=" + price + ", stock=" + stock + ", pic=" + pic + "]";
	}
	
	
     
     
}

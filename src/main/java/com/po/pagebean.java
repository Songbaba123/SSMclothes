package com.po;

import java.util.List;

public class pagebean {
	   //当前页
       private  int  page=1;
       //每页展示数
       private  int  rows=5;
       //总页数
       private  int  maxpage;
       //分页查询返回的记录集合
       private  List<?>  pagelist;
	public pagebean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public pagebean(int page, int rows, int maxpage, List<?> pagelist) {
		super();
		this.page = page;
		this.rows = rows;
		this.maxpage = maxpage;
		this.pagelist = pagelist;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
	public List<?> getPagelist() {
		return pagelist;
	}
	public void setPagelist(List<?> pagelist) {
		this.pagelist = pagelist;
	}
       
}

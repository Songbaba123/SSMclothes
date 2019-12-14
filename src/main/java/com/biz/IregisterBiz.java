package com.biz;

import java.util.List;

import com.po.pagebean;
import com.po.register;


public interface IregisterBiz {
    //登录（增改删查）
    public  boolean   save(register  rt);
    public  boolean   update(register  rt);
    public  boolean   delbyid(String iid);
    public  boolean   delbyreg(Integer regid);
    public  register   findbyid(Integer regid);
    public  register   findbyiid(String  iid);
    public  List<register>   findalll();
    public  List<register>   findall(pagebean  pb);
    public  int   findmaxrows();
}

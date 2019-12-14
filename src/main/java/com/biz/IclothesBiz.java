package com.biz;

import java.util.List;

import com.po.clothes;
import com.po.pagebean;
public interface IclothesBiz {
    //服装（增改删查）
    public  boolean   save(clothes  cs);
    public  boolean   update(clothes  cs);
    public  boolean   delbyid(Integer clid);
    public  clothes   findbyid(Integer clid);
    public  List<clothes>   findall(pagebean  pb);
    public  int   findmaxrows();
}

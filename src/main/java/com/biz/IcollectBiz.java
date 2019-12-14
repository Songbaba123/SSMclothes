package com.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.po.collect;
import com.po.pagebean;

@Service("collectbiz")
public interface IcollectBiz {
    //收货（增改删查）
    public  boolean   save(collect  ct);
    public  boolean   update(collect  ct);
    public  boolean   delbyid(Integer coid);
    public  collect   findbyid(Integer coid);
    public  List<collect>   findall(Integer  regid);
    public  int   findamaxrows();
}

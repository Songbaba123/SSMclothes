package com.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.po.collect;
import com.po.pagebean;

@Service("collectdao")
public interface IcollectMapper {
    //收货（增改删查）
    public  int   save(collect  ct);
    public  int   update(collect  ct);
    public  int   delbyid(Integer coid);
    public  int   delbyiid(Integer regid);
    public collect  findbyid(Integer coid);
    public  List<collect>   findall(Integer regid);
    public  int   findamaxrows();
}

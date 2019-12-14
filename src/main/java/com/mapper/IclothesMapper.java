package com.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.po.clothes;
import com.po.pagebean;
@Service("clothesdao")
public interface IclothesMapper {
    //服装（增改删查）
    public  int   save(clothes  cs);
    public  int   update(clothes  cs);
    public  int   delbyid(Integer clid);
    public  clothes   findbyid(Integer clid);
    public  List<clothes>   findall(pagebean  pb);
    public  int   findmaxrows();
}

package com.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.po.clothes;
import com.po.pagebean;
import com.po.register;

@Service("registerdao")
public interface IregisterMapper {
    //登录（增改删查）
    public  int   save(register  rt);
    public  int   update(register  rt);
    public  int   delbyid(String  iid);
    public  int   delbyreg(Integer regid);
    public  register   findbyid(Integer regid);
    public  register   findbyiid(String  iid);
    public  List<register>   findalll();
    public  List<register>   findall(pagebean  pb);
    public  int   findmaxrows();
}

package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.*;

public interface action {
  //服装（clothes）
  public String  savec(HttpServletRequest  request,HttpServletResponse response,clothes cs);
  public String  updatec(HttpServletRequest  request,HttpServletResponse response,clothes cs);
  public String  delbyidc(HttpServletRequest  request,HttpServletResponse response,Integer clid);
  public String  findbyidc(HttpServletRequest  request,HttpServletResponse response,Integer clid);
  public String  findallc(HttpServletRequest  request,HttpServletResponse response,Integer page,Integer rows);
  //登录（register）
  public String  saver(HttpServletRequest  request,HttpServletResponse response,register rt);
  public String  updater(HttpServletRequest  request,HttpServletResponse response,register rt);
  public String  delbyregr(HttpServletRequest  request,HttpServletResponse response,Integer regid);
  public String  delbyiidr(HttpServletRequest  request,HttpServletResponse response,register rt);
  public String  findbyidr(HttpServletRequest  request,HttpServletResponse response,String  iid);
  public String  findallr(HttpServletRequest  request,HttpServletResponse response,Integer page,Integer rows);
  public  String  findalllr(HttpServletRequest  request,HttpServletResponse response,register rt);
  //地址信息（collect）
  public String  savet(HttpServletRequest  request,HttpServletResponse response,collect ct);
  public String  updatet(HttpServletRequest  request,HttpServletResponse response,collect ct);
  public String  delbyidt(HttpServletRequest  request,HttpServletResponse response,Integer coid);
  public String  findbyidt(HttpServletRequest  request,HttpServletResponse response,Integer coid);
  public String  findallt(HttpServletRequest  request,HttpServletResponse response,Integer regid);
  //订单（orderform）
  public String  saveo(HttpServletRequest  request,HttpServletResponse response,orderform cs);
  public String  updateo(HttpServletRequest  request,HttpServletResponse response,orderform cs);
  public String  delbyido(HttpServletRequest  request,HttpServletResponse response,Integer ordid);
  public String  findbyiido(HttpServletRequest  request,HttpServletResponse response,Integer ordid);
  public String  findbyido(HttpServletRequest  request,HttpServletResponse response,Integer regid);
  public String  findallo(HttpServletRequest  request,HttpServletResponse response,Integer page,Integer rows);

}

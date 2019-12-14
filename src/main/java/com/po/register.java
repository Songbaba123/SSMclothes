package com.po;

import java.io.Serializable;

public class register implements Serializable{
	//登录表
     private  Integer  regid;//账号编号
     private  String   iid;//账号
     private  String   passwd;//密码
     private  String   question;//问题
     private  String   answer;//答案
	public register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public register(Integer regid, String iid, String passwd, String question, String answer) {
		super();
		this.regid = regid;
		this.iid = iid;
		this.passwd = passwd;
		this.question = question;
		this.answer = answer;
	}
	public Integer getRegid() {
		return regid;
	}
	public void setRegid(Integer regid) {
		this.regid = regid;
	}
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "register [regid=" + regid + ", iid=" + iid + ", passwd=" + passwd + ", question=" + question
				+ ", answer=" + answer + "]";
	}
	
     
     
}

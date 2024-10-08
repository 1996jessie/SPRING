package com.spring.ex.bean;

public class MemberBean {
	private String id;
	private String pw;
	private String addr;
	private String age;
	
	public MemberBean() {
		super();
		System.out.println("MemberBean()");
	}
	public MemberBean(String id, String pw, String addr, String age) {
		super();
		this.id = id;
		this.pw = pw;
		this.addr = addr;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}

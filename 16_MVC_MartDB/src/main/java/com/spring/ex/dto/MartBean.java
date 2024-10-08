package com.spring.ex.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MartBean {
	private int num;

	@NotEmpty(message = "id 입력 누락")
	private String id;
	
	@NotBlank(message = "pw 입력 누락")
	private String pw;
	
	@NotNull(message = "product 입력 누락")
	private String product;
	
	//@NotEmpty(message = "time 입력 누락")
	@NotBlank(message = "time 입력 누락")
	//@NotNull //안됨
	private String time;
	
	@NotEmpty(message = "approve 입력 누락")
	private String approve;
	
	@NotBlank(message = "agree 입력 누락")
	private String agree;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
}

/*
text : @NotBlank, @NotEmpty
select : @NotBlank, @NotEmpty
checkbox : @NotNull, @NotBlank, @NotEmpty
radio : @NotNull, @NotBlank, @NotEmpty
*/

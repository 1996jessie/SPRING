package com.spring.ex.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class FDto {
	private final String msg = " 입력 누락"; //절대 변하지 않도록 선언해야 오류 안남
	private int num;
	@NotEmpty(message = "id" + msg)
	private String id;
	@NotBlank(message = "pw 입력 누락")
	private String pw;
	@NotNull(message = "우승 예상 국가 입력 누락")
	private String win;
	@NotNull(message = "16강 예상 국가 입력 누락")
	private String round16;
	
	public FDto() {
		super();
	}
	
	public FDto(int num, String id, String pw, String win, String round16) {
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.win = win;
		this.round16 = round16;
	}
	
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
	public String getWin() {
		return win;
	}
	public void setWin(String win) {
		this.win = win;
	}
	public String getRound16() {
		return round16;
	}
	public void setRound16(String round16) {
		this.round16 = round16;
	}
	
}

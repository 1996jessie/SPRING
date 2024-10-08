package com.sping.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExamController {
	@RequestMapping("board/form") 
	public String list2() {
		return "form";
	}
	
	/*
	@RequestMapping("/member") //클래스가 달라도 똑같은 요청명이 2개 있으면 에러
	public String view() {
		return "form";
	}
	*/
}

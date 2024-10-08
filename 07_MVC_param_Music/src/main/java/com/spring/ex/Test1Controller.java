package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test1Controller {
	
	@RequestMapping("test1form")
	public String test1() {
		return "test1/Test1Form";
	}
	
	@RequestMapping("test1/join1")
	public String result() {
		return "test1/test1Result";
	}
}
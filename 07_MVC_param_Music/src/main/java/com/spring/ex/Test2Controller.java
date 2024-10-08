package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test2Controller {
	//http://localhost:8080/ex/test2/test2form
	@RequestMapping("test2/test2form")
	public String test1() {
		return "test2/Test2Form";
	}
	
	//http://localhost:8080/ex/test2/test2/join2?id=sdsf
	//@RequestMapping("test2/test2/join2")
	@RequestMapping("test2/join2")
	public String result() {
		return "test2/test2Result";
	}
}
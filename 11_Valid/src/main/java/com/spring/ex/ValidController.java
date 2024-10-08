package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidController {
	@RequestMapping("form")
	public String form() {
		return "form";
	}
	
	@RequestMapping("insert")
	public String insert(@ModelAttribute("per") @Valid Person ps, BindingResult result) { //result에 에러가 발생했다는 정보가 들어옴
		System.out.println("result.hasErrors() : " + result.hasErrors()); //false : 둘 다 에러 아님 / true : 하나라도 에러
		String page = "result"; //에러 없으면 result.jsp
		if(result.hasErrors()) { //에러 있으면 form.jsp
			page = "form";
		}
		return page;
	}
}

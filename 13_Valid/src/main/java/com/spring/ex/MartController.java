package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MartController {
	@RequestMapping("insertForm")
	public String insertForm() {
		return "insertForm";
	}
	
	@RequestMapping("insert")
	public String insert(@ModelAttribute("m") @Valid MartBean mb, BindingResult result) {
		String page = "result";
		if(result.hasErrors()) {
			page = "insertForm";
		}
		return page;
	}
}

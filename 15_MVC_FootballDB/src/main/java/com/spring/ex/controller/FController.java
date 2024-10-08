package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex.command.*;
import com.spring.ex.dto.FDto;

@Controller
public class FController {
	FCommand command = null;
	@RequestMapping("insertForm")
	public String insertForm() {
		return "insertForm";
	}
	
	@RequestMapping("insert")
	public String insert(HttpServletRequest request, Model model) {
		model.addAttribute("req", request);
		command = new FInsertCommand();
		command.execute(model);
		return "redirect:/list";
	}
	
	@RequestMapping("validInsertForm")
	public String ValidInsertForm() {
		return "validInsertForm";
	}
	
	@RequestMapping("validInsert")
	public String insert(@ModelAttribute("fdto") @Valid FDto fdto, BindingResult result, HttpServletRequest request, Model model) {
		//model.addAttribute("req", request);
		//model.addAttribute("fd", fdto);
		if(result.hasErrors()) {
			return "validInsertForm"; //아래를 만나지 말고 바로 돌아가라
		}
		command = new FValidInsertCommand();
		command.execute(model);
		return "redirect:/list";
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		command = new FListCommand();
		command.execute(model);
		return "list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("req", request);
		command = new FDeleteCommand(); 
		command.execute(model);
		
		return "redirect:/list";
	}
	
	@RequestMapping("updateForm")
	public String updateForm(HttpServletRequest request,Model model) {
		
		model.addAttribute("req",request);
		command = new FUpdateFormCommand(); 
		command.execute(model);
		
		return "updateForm";
	}
	
	@RequestMapping("validUpdateForm")
	public String validUpdateForm(HttpServletRequest request,Model model) {
		
		model.addAttribute("req",request);
		command = new FUpdateFormCommand(); 
		command.execute(model);
		
		return "validUpdateForm";
	}
	
	@RequestMapping("validUpdate")
	public String validUpdateForm(@ModelAttribute("fdto") @Valid FDto fdto, BindingResult result, HttpServletRequest request, Model model) {
		if(result.hasErrors()) {
			return "validUpdateForm";
		}
		command = new FValidUpdateCommand();  
		command.execute(model);
		return "redirect:/list";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, Model model) {
		
		model.addAttribute("req", request);
		
		command = new FUpdateCommand();
		command.execute(model); 
		
		return "redirect:list";
	}
	

	
}


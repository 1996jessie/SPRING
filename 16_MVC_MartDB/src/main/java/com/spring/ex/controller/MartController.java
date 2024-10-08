package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex.command.*;
import com.spring.ex.dto.MartBean;

@Controller
public class MartController {
	MCommand command = null;
	@RequestMapping("insertForm")
	public String insertForm() {
		return "insertForm";
	}

	@RequestMapping("insert")
	public String insert(@ModelAttribute("mb") @Valid MartBean mb, BindingResult result, HttpServletRequest request, Model model) {
		if(result.hasErrors()) {
			return "insertForm";
		}
		command = new MInsertCommand();
		command.execute(model);
		return "redirect:/list";
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		command = new MListCommand();
		command.execute(model);
		return "list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("req", request);
		command = new MDeleteCommand(); 
		command.execute(model);
		return "redirect:/list";
	}
	
	@RequestMapping("deleteAll")
	public String deleteAll(HttpServletRequest request,Model model) {
		model.addAttribute("req", request);
		command = new MDeleteAllCommand();
		command.execute(model);
		return "redirect:/list";
	}
	
	@RequestMapping("updateForm")
	public String updateForm(HttpServletRequest request, Model model) {
		model.addAttribute("req",request);
		command = new MUpdateFormCommand(); 
		command.execute(model);
		return "updateForm";
	}
	
	@RequestMapping("update")
	public String update(@ModelAttribute("mb") @Valid MartBean mb, BindingResult result, HttpServletRequest request, Model model) {
		if(result.hasErrors()) {
			return "updateForm";
		}
		command = new MUpdateCommand();  
		command.execute(model);
		return "redirect:/list";
	}
}

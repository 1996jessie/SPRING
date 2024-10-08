package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	@RequestMapping("form")
	public String form() {
		return "form";
	}
	
	@RequestMapping("input1")
	public String input1(HttpServletRequest request) {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String publisher = request.getParameter("publisher");
		
		request.setAttribute("title", title);
		request.setAttribute("author", author);
		request.setAttribute("price", price);
		request.setAttribute("publisher", publisher);
		
		return "result1";
	}
	
	@RequestMapping("input2")
	public String input2(HttpServletRequest request, @RequestParam("title") String title, @RequestParam("author") String author, @RequestParam("price") int price, @RequestParam("publisher") String publisher) {
		
		request.setAttribute("title", title);
		request.setAttribute("author", author);
		request.setAttribute("price", price);
		request.setAttribute("publisher", publisher);
		
		return "result2";
	}
	
	@RequestMapping("input3")
	public ModelAndView input3(@RequestParam("title") String title, @RequestParam("author") String author, @RequestParam("price") int price, @RequestParam("publisher") String publisher) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", title);
		mav.addObject("author", author);
		mav.addObject("price", price);
		mav.addObject("publisher", publisher);
		mav.setViewName("result3");
		return mav;
	}
	
	@RequestMapping("input4")
	public String input4(BookBean bb) {
		return "result4";
	}
	
	@RequestMapping("input5")
	public String input5(@ModelAttribute("book") BookBean bb) {
		return "result5";
	}
}

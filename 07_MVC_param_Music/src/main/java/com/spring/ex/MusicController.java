package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.ex.bean.MusicBean;

@Controller
public class MusicController {
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping("/input1")
	public String input1(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		String singer = request.getParameter("singer");
		String price = request.getParameter("price");
		
		request.setAttribute("title", title);
		request.setAttribute("singer", singer);
		request.setAttribute("price", price);
		
		/*
		model.addAttribute("title", title);
		model.addAttribute("singer", singer);
		model.addAttribute("price", price);
		*/
		
		return "music/result1";
	}
	
	@RequestMapping("/input2")
	public String input2(HttpServletRequest request, @RequestParam("title") String title, @RequestParam("singer") String singer, @RequestParam("price") int price) {
		request.setAttribute("title", title);
		request.setAttribute("singer", singer);
		request.setAttribute("price", price);
		
		MusicBean mb = new MusicBean();
		mb.setTitle(title);
		mb.setSinger(singer);
		mb.setPrice(price);
		
		request.setAttribute("mb", mb);
		
		return "music/result2";
	}
	
	@RequestMapping("input3")
	public ModelAndView input3(@RequestParam("title") String title,	@RequestParam("singer") String singer, @RequestParam("price") int price) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", title);
		mav.addObject("singer", singer);
		mav.addObject("price", price);
		
		MusicBean mb = new MusicBean(); 
		
		mb.setTitle(title);
		mb.setSinger(singer);
		mb.setPrice(price); 
		mav.addObject("mb", mb);
		
		mav.setViewName("/music/result3");
		
		return mav;
	}
	
	@RequestMapping("/input4")
	public String input4(MusicBean mb) {
		return "music/result4";
	}
	
	@RequestMapping("/input5")
	public String input5(@ModelAttribute("music") MusicBean mb) {
		return "music/result5";
	}
}

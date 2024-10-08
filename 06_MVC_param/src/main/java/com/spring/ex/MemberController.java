package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.ex.bean.MemberBean;

@Controller
public class MemberController {
	@RequestMapping("/member/input")
	public String input() {
		return "member/result";
	}
	
	/* http://localhost:8080/ex/member/input2?id=kim&pw=1234  */
	@RequestMapping("/member/input2")
	public String input2(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("input2 id : " + id);
		System.out.println("input2 pw : " + pw);
		
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		
		return "member/result2";
	}
	
	/* http://localhost:8080/ex/member/input3?id=kim&pw=1234&addr=seoul&age=30  */
	@RequestMapping("/member/input3")
	public String input3(HttpServletRequest request, @RequestParam("id") String id, @RequestParam("pw") String pw, @RequestParam("addr") String addr, @RequestParam("age") String age, Model model) {
		
		System.out.println("input3 id : " + id);
		System.out.println("input3 pw : " + pw);
		
		//request.setAttribute("id", id);
		//request.setAttribute("pw", pw);
			
		//model.addAttribute("id", id);
		//model.addAttribute("pw", pw);
		//model.addAttribute("addr", addr);
		//model.addAttribute("age", age);
		
		MemberBean mb = new MemberBean();
		mb.setId(id);
		mb.setPw(pw);
		mb.setAddr(addr);
		mb.setAge(age);
		model.addAttribute("mb", mb);
		
		return "member/result3";
	}
	
	/* http://localhost:8080/ex/member/input4?id=kim&pw=1234&addr=seoul&age=30  */
	@RequestMapping("/member/input4")
	public String input4(MemberBean mb) {
		/*
		MemberBean mb : command 객체
		MemberBean mb가 가진 의미 : 파라미터로 받기+Bean 객체 생성+setter 주입+속성 설정
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String addr = request.getParameter("addr");
		String age = request.getParameter("age");
		
		MemberBean mb = new MemberBean();
		mb.setId(id);
		mb.setPw(pw);
		mb.setAddr(addr);
		mb.setAge(age);
		model.addAttribute("memberBean", mb); //소문자로 속성 받음
		*/
		System.out.println("MemberController mb.getId() : " + mb.getId());
		return "member/result4";
	}
	
	/* http://localhost:8080/ex/member/input5?id=kim&pw=1234&addr=seoul&age=30  */
	@RequestMapping("/member/input5")
	public String input5(@ModelAttribute("abcd") MemberBean mb) { //@ModelAttribute("abcd") : command 객체의 별칭 지정 
		//model.addAttribute("abcd", mb);
		return "member/result5";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
}

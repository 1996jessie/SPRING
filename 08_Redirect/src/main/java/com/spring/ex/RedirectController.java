package com.spring.ex;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("form")
	public String form() {
		return "form";
	}
	
	@RequestMapping("sub")
	public String sub(HttpServletRequest request, Model model, RedirectAttributes attr) {
		System.out.println("sub 요청 sub()");
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("map_name", name); //map_name = 김연아
		attr.addFlashAttribute("mapAttr", map); //속성 설정
		request.setAttribute("rname", name);
		model.addAttribute("mname", name);
		//return "result";
		
		return "redirect:/sub2"; //다시 컨트롤러 요청 : 리다이렉트한다
	}
	
	@RequestMapping("sub2")
	public String sub2(HttpServletRequest request, Model model) {
		System.out.println("sub2 요청 sub2()");
		
		String name = request.getParameter("name");
		System.out.println("name2 : " + name);
		
		String rname = request.getParameter("rname");
		System.out.println("rname : " + rname);
		
		String mname = request.getParameter("mname"); // 이것만 가능
		System.out.println("mname : " + mname);
		
		String rname2 = (String) request.getAttribute("rname");
		System.out.println("rname2 : " + rname2);
		
		String mname2 = (String) request.getAttribute("mname");
		System.out.println("mname2 : " + mname2);
		return "result";
		
		//모델로 설정해서 파라미터로 가지고 와야만 값 넘길 수 있음
	}
	
}

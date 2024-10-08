package com.spring.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.ex.bean.PersonBean;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/* http://localhost:8080/ex/person/input?name=kim&age=30 */
	@RequestMapping("/person/input")
	public String result(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("HC name : " + name);
		
		request.setAttribute("name2", name+ "¾¾");
		return "/person/result";
	}

	/* http://localhost:8080/ex/person/join?id=choi&pw=1234&name=kim&addr=seoul */
	@RequestMapping("person/join")
	public String view(HttpServletRequest request, @RequestParam("id") String id, @RequestParam("pw") String pw, @RequestParam("name") String name, @RequestParam("addr") String addr) { //String a = request.getParameter("id") String b = request.getParameter("pw")¿Í °°À½
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("name : " + name);
		System.out.println("addr : " + addr);
		
		PersonBean pb = new PersonBean();
		pb.setId(id);
		pb.setPw(pw);
		pb.setName(name);
		pb.setAddr(addr);
		
		request.setAttribute("pb", pb);
		/*
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		request.setAttribute("name", name);
		request.setAttribute("addr", addr);
		*/
		return "person/personView";
	}
	
	/* http://localhost:8080/ex/person/join2?id=choi&pw=1234&name=kim&addr=seoul */
	@RequestMapping("person/join2")
	public String view(PersonBean pb) {
		return "person/personView2";
	}
	
}

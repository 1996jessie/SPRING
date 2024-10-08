package com.sping.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller //@~~ : annotation(파일에 대한 설명)
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) //method 쓸 때는 value 꼭 써야 함(/를 get 방식으로 요청했을 때 아래 메서드 실행)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		//request.addAttribute("serverTime", formattedDate); 와 비슷
		//속성으로 챙겨서 el코드로 접근할 수 있다는 공통점
		return "home"; //중간부분 >> /WEB-INF/views/home.jsp로 이동할 위치 설정
	} //home
	
	//member 요청하면 view 메서드 호출되면서 WEB-INF/views/memberView.jsp로 이동
	@RequestMapping("/member") //value 안 써도 됨 //요청명은 중복되면 안됨 //메서드 안 쓰면 get, post 둘 다 됨
	public String view() {
		return "memberView"; //WEB-INF/views/memberView.jsp
	}
	
	@RequestMapping(value="/fruit", method = RequestMethod.GET) //꼭 get 방식일 때만 실행
	public String fruit() {
		return "apple";
	}
	
	@RequestMapping("/member/input")
	public String input(Model model) {
		model.addAttribute("id", "kim");
		model.addAttribute("name", "김연아");
		return "/member/input"; //WEB-INF/views/member/input.jsp
	}
	
	@RequestMapping(value="/member/list", method = RequestMethod.GET) //POST 방식으로 요청하면 안됨
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "웬디");
		mav.addObject("age", 30);
		mav.setViewName("/member/list");
		return mav; 
	}
	
	@RequestMapping("member/list2") //앞에 / 안 붙여도 됨
	public ModelAndView list2() {
		//return "member/list2"; //앞에 / 안 붙여도 됨
		
		/*
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("member/list2");
		return mav;
		 */
		
		ModelAndView mav = new ModelAndView("member/list2"); 
		return mav;
	}
	
}

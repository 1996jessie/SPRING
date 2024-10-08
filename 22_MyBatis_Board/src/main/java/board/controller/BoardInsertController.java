package board.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardInsertController {
	final String command = "insert.bd";
	final String getPage = "boardInsertForm";
	final String gotoPage = "redirect:/boardList.bd";
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String insert(HttpSession session) { //자동으로 만들어진 객체가 session에 들어옴
		//로그인 성공하면 loginInfo 세션 설정
		//자바에서는 ServletContext, HttpSession 사용
		System.out.println("loginInfo : " + session.getAttribute("loginInfo")); //아직 설정 안함 : null
		
		if(session.getAttribute("loginInfo") == null) { //로그인 못함
			session.setAttribute("destination", "redirect:/insert.bd");
			return "redirect:/loginForm.mb";
		} else { //로그인 성공			
			return getPage;
		}
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView insertArticle(@ModelAttribute("board") @Valid BoardBean bb, BindingResult result, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav; 
		}
		
		bb.setIp(request.getRemoteAddr());
		
		int cnt = -1;
		cnt = boardDao.insertArticle(bb);
		System.out.println("BoardInsertContoller insertArticle cnt : " + cnt);
		if(cnt != -1) {
			mav.setViewName(gotoPage);
		} else {
			mav.setViewName(getPage);
		}
		return mav;
	
	}
	
}

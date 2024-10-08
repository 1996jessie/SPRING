package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardUpdateController {
	private final String command = "/update.bd";
	private final String getPage = "boardUpdateForm";
	private final String gotoPage = "redirect:/boardList.bd";
	private final String loginPage = "redirect:/loginForm.mb";
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public ModelAndView updateForm(
			@RequestParam(value =  "num", required = true) int num,
			@RequestParam(value = "pageNumber") int pageNumber,
			@RequestParam(value =  "whatColumn", required = false) String whatColumn,
			@RequestParam(value =  "keyword", required = false) String keyword,
			HttpSession session, Model model) { //자동으로 만들어진 객체가 session에 들어옴
		System.out.println(this.getClass() + "(Get) num : " + num +"/pageNumber : "+ pageNumber + "/whatColumn : " + whatColumn + "/keyword : " + keyword);
		
		ModelAndView mav = new ModelAndView();
		System.out.println("loginInfo : " + session.getAttribute("loginInfo")); //아직 설정 안함 : null
		if(session.getAttribute("loginInfo") == null) { //로그인 못함
			session.setAttribute("destination", "redirect:/update.bd?num="+num);
			mav.addObject("pageNumber", pageNumber);
			mav.addObject("whatColumn", whatColumn);
			mav.addObject("keyword", keyword);
			mav.setViewName(loginPage);	
		} else { //로그인 성공			
			BoardBean bb = boardDao.detailArticle(num);
			mav.addObject("board", bb);
			mav.addObject("pageNumber", pageNumber);
			mav.addObject("whatColumn", whatColumn);
			mav.addObject("keyword", keyword);
			mav.setViewName(getPage);
		}
		return mav;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView update(
			@ModelAttribute("board") @Valid BoardBean bb, BindingResult result, 
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("whatColumn") String whatColumn,
			@RequestParam("keyword") String keyword,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav; 
		}

		String originPasswd = null;
		int cnt = -1;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		out = response.getWriter();
		
		BoardBean originArticle = boardDao.detailArticle(bb.getNum());
		originPasswd = originArticle.getPasswd();
		System.out.println("BoardUpdateController 원래 passwd : " + originPasswd);
		System.out.println("입력한 passwd : " + bb.getPasswd());
		if(originPasswd.equals(bb.getPasswd())) {
			cnt = boardDao.updateArticle(bb);
			System.out.println("BoardUpdateController cnt : " + cnt);
			mav.addObject("pageNumber", pageNumber);
			mav.addObject("whatColumn", whatColumn);
			mav.addObject("keyword", keyword);
			mav.setViewName(gotoPage);
			return mav;
		} else {
			out.print("<script>alert('비밀번호 틀림');</script>");
			out.flush();
			
			System.out.println("비밀번호 달라서 수정 못함");
			mav.setViewName(getPage);
			return mav;
		}
	}

}

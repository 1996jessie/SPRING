package board.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
public class BoardReplyController {
	private final String command = "/reply.bd";
	private final String getPage = "boardReplyForm";
	private final String gotoPage = "redirect:/boardList.bd";
	private final String loginPage = "redirect:/loginForm.mb";
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public ModelAndView replyForm(
		@RequestParam(value =  "num", required = true) int num,
		@RequestParam(value = "pageNumber") int pageNumber,
		@RequestParam(value =  "whatColumn", required = false) String whatColumn,
		@RequestParam(value =  "keyword", required = false) String keyword,
		HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		
		if(session.getAttribute("loginInfo") == null) { //로그인 못함
			session.setAttribute("destination", "redirect:/reply.bd?num="+num);
			mav.addObject("pageNumber", pageNumber);
			mav.addObject("whatColumn", whatColumn);
			mav.addObject("keyword", keyword);
			mav.setViewName(loginPage);	
		} else {
			
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
	public ModelAndView reply(@ModelAttribute("board") @Valid BoardBean bb, BindingResult result, 
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("whatColumn") String whatColumn,
			@RequestParam("keyword") String keyword,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav; 
		}
		
		bb.setIp(request.getRemoteAddr());
		
		int ucnt = -1;
		int rcnt = -1;
		ucnt = boardDao.updateReplyArticle(bb);
		System.out.println("BoardInsertContoller updateReplyArticle ucnt : " + ucnt);
		
		if(ucnt == -1) {
			System.out.println("실패");
		} else {
			bb.setIp(request.getRemoteAddr());
			rcnt = boardDao.insertReplyArticle(bb);
			System.out.println("BoardInsertContoller insertReplyArticle rcnt : " + rcnt);
			mav.addObject("pageNumber", pageNumber);
			mav.addObject("whatColumn", whatColumn);
			mav.addObject("keyword", keyword);
			mav.setViewName(gotoPage);
		}

		return mav;
	}
	
}

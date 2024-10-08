package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberDao;

@Controller
public class MemberDeleteController {
	private final String command = "/delete.mb";
	private final String gotoPage = "redirect:/memberList.mb";
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(command)
	public ModelAndView delete(@RequestParam String id,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam("whatColumn") String whatColumn,
			@RequestParam("keyword") String keyword) {
		
		ModelAndView mav = new ModelAndView();
		
		memberDao.deleteMember(id);
		
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);
		mav.setViewName(gotoPage);
		
		return mav;
	}
	
}

package member.controller;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;
import product.model.ProductBean;

@Controller
public class MemberUpdateController {
	private final String command = "update.mb";
	private final String getPage = "memberUpdateForm";
	private final String gotoPage = "redirect:/memberList.mb";
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public ModelAndView updateForm(
					@RequestParam(value="id") String id, 
					@RequestParam(value="pageNumber") String pageNumber,
					@RequestParam(value="whatColumn") String whatColumn,
					@RequestParam(value="keyword") String keyword
					) {
		MemberBean member = memberDao.detailMember(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("member") @Valid MemberBean mb, BindingResult result,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("whatColumn") String whatColumn,
			@RequestParam("keyword") String keyword) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		memberDao.updateMember(mb);

		mav.addObject("pageNumber", pageNumber);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);
		
		mav.setViewName(gotoPage);
		return mav;
	}
	
	
}

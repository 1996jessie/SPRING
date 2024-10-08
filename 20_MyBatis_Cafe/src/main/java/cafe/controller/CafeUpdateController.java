package cafe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cafe.model.CafeBean;
import cafe.model.CafeDao;


@Controller
public class CafeUpdateController {
	private final String command = "update.cf";
	private final String getPage = "cafeUpdateForm";
	private final String gotoPage = "redirect:/list.cf";
	
	@Autowired
	private CafeDao cdao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public ModelAndView updateForm(
			@RequestParam(value="num", required = true) int num, 
					@RequestParam(value="pageNumber", required = false) String pageNumber,
					@RequestParam(value="whatColumn", required = false) String whatColumn,
					@RequestParam(value="keyword", required = false) String keyword
					) {
		
		CafeBean cafe = cdao.detailCafe(num);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cafe", cafe);
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("cafe") @Valid CafeBean cafe, BindingResult result,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("whatColumn") String whatColumn,
			@RequestParam("keyword") String keyword) {
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		cdao.updateCafe(cafe);
		
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);
		
		mav.setViewName(gotoPage);
		return mav;
	}
	
}

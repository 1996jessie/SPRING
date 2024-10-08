package cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cafe.model.CafeDao;



@Controller
public class CafeDeleteController {
	private final String command="/delete.cf";
	private final String gotoPage="redirect:/list.cf";
	
	@Autowired
	CafeDao cdao;
	
	@RequestMapping(command)
	public ModelAndView delete(@RequestParam int num, 
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam("whatColumn") String whatColumn,
			@RequestParam("keyword") String keyword) {
		
		System.out.println("whatColumn : " + whatColumn);
		
		ModelAndView mav = new ModelAndView();
		cdao.deleteCafe(num);
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		mav.setViewName(gotoPage);
		
		return mav;
	}
}

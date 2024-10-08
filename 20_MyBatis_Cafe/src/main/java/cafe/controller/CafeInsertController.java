package cafe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cafe.model.CafeBean;
import cafe.model.CafeDao;


@Controller
public class CafeInsertController {
	private final String command = "/insert.cf";
	private final String getPage = "cafeInsertForm";
	private final String gotoPage = "redirect:/list.cf";

	@Autowired
	CafeDao cdao; 

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}

	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("cafe") @Valid CafeBean cafe, BindingResult result) {
		ModelAndView mav = new ModelAndView();

		if(result.hasErrors()) {
			mav.setViewName(getPage); // cafeInsertForm
			return mav;
		}
		
		int cnt = -1;
		cnt = cdao.insertCafe(cafe);
		
		if(cnt != -1) {	
			mav.setViewName(gotoPage);
		}
		else {
			mav.setViewName(getPage);
		}
		return mav;
	}
}

package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelInsertController {

	private final String command = "/insert.tv";
	private final String getPage = "travelInsertForm";
	private final String gotoPage = "redirect:/list.tv";

	@Autowired
	private TravelDao travelDao;

	// 
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String insert() {
		return getPage;
	}

	// 
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("travel") @Valid TravelBean travel, BindingResult result) {
		System.out.println("test2 post방식 요청");
		ModelAndView mav = new ModelAndView();

		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}

		int cnt = -1;
		cnt = travelDao.insertTravel(travel);
		if(cnt != -1) {
			mav.setViewName(gotoPage);
		}else {
			//mav.setViewName("redirect:"+command);
			mav.setViewName(getPage);
		}
		return mav;
	}
}

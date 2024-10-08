package travel.controller;

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

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {
	private final String command = "update.tv";
	private final String getPage = "travelUpdateForm";
	private final String gotoPage = "redirect:/list.tv";

	@Autowired
	private TravelDao travelDao;

	// 
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String updateForm(
							@RequestParam("num") int num, 
							@RequestParam("pageNumber") int pageNumber,
							Model model) {

		TravelBean travelBean =  travelDao.getTravelByNum(num);
		model.addAttribute("travel", travelBean);
		model.addAttribute("pageNumber", pageNumber);
		return getPage; // travelUpdateForm
	}

	// 
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("travel") @Valid TravelBean travel, BindingResult result,
							@RequestParam(value="pageNumber",required = true) int pageNumber ) {

		System.out.println("pageNumber : " + pageNumber);
		System.out.println(travel.getArea());
		
		ModelAndView mav = new ModelAndView();

		if(result.hasErrors()) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
			return mav;
		} 
		int cnt = -1;
		cnt = travelDao.updateTravel(travel);
		if(cnt != -1) {
			mav.addObject("pageNumber", pageNumber);
			mav.setViewName(gotoPage); // "redirect:/list.tv"
			
		}else {
			mav.addObject("num",travel.getNum());
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName("redirect:/"+command); // redirect:/update.tv
		}
		
		return mav;
	}
}



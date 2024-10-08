package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelDao;

@Controller
public class TravelDeleteController {

	private final String command = "delete.tv";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	TravelDao travelDao;
	
	// travelList.jsp 삭제버튼 클릭
	@RequestMapping(value=command)
	public String doAction(@RequestParam(value="num",required=true) int num,
			@RequestParam(value="pageNumber",required=true) int pageNumber) {
		
		System.out.println(num +"/" + pageNumber);
		
		int cnt = travelDao.deleteTravel(num);
		return gotoPage+"?pageNumber=" + pageNumber;
		//return "redirect:/list.tv?pageNumber="+pageNumber;
	}
	
}
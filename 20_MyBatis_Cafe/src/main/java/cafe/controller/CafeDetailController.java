package cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.model.CafeBean;
import cafe.model.CafeDao;


@Controller
public class CafeDetailController {
	private final String command = "detail.cf";
	private final String getPage = "cafeDetailView";
	
	@Autowired
	CafeDao cdao;
	
	@RequestMapping(command)
	public String detail(@RequestParam("num") int num, 
						@RequestParam("pageNumber") int pageNumber, 
						@RequestParam("whatColumn") String whatColumn,
                        @RequestParam("keyword") String keyword,
						Model model) {
		
		CafeBean cb = cdao.detailCafe(num);
		model.addAttribute("cafe", cb);
		model.addAttribute("pageNumber", pageNumber);
		
		return getPage; // cafeDetailView
	}
}

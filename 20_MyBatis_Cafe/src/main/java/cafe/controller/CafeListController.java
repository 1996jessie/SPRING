package cafe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cafe.model.CafeBean;
import cafe.model.CafeDao;

import utility.Paging;

@Controller
public class CafeListController {
	private final String command = "list.cf";
	private final String getPage = "cafeList";
	
	@Autowired
	CafeDao cdao; 
	
	@RequestMapping(value = command)
	private ModelAndView list(
			@RequestParam(value = "whatColumn", required = false) String whatColumn, 
			@RequestParam(value = "keyword", required = false) String keyword,
			 @RequestParam(value = "pageNumber", required = false) String pageNumber,
			 HttpServletRequest request
			) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%" + keyword + "%");
		
		int totalCount = cdao.getTotalCount(map); //Å°¿öµå °¹¼ö
		String url = request.getContextPath() + "/" +  this.command;
		 
		Paging pageInfo = new Paging(pageNumber,null,totalCount,url,whatColumn,keyword);
		
		List<CafeBean> cafeList = cdao.getCafeList(map,pageInfo);
		mav.addObject("cafeList",cafeList);
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		mav.setViewName(getPage); // cafeList
		
		return mav;
	}
}



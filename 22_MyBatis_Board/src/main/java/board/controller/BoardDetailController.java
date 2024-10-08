package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardDetailController {
	
	@Autowired
	BoardDao boardDao;
	
	private final String command = "/detailArticle.bd";
	private final String getPage = "boardDetailView";
	
	@RequestMapping(value=command)
	public String detailArticleView(
			@RequestParam(value =  "num", required = true) int num,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam(value =  "whatColumn") String whatColumn,
			@RequestParam(value =  "keyword") String keyword,
			Model model) {
		System.out.println(this.getClass() + "(Post) num : " + num +"/pageNumber : "+ pageNumber + "/whatColumn : " + whatColumn + "/keyword : " + keyword);
		
		boardDao.updateReadcount(num);
		BoardBean bb = boardDao.detailArticle(num);
		
		
		model.addAttribute("board", bb);
			
		model.addAttribute("num", num);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("whatColumn", whatColumn);
		model.addAttribute("keyword", keyword);


		return getPage;
	
	}
	
}

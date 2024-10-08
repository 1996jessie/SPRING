package movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieDetailController {
	private final String command = "detail.mv";
	private final String getPage = "movieDetailView";
	
	@Autowired
	MovieDao movieDao;
	
	@RequestMapping(command)
	public String detail(@RequestParam("num") int num, 
						@RequestParam("pageNumber") int pageNumber, 
						@RequestParam("whatColumn") String whatColumn,
                        @RequestParam("keyword") String keyword,
						Model model) {
		
		MovieBean mb = movieDao.detailMovie(num);
		model.addAttribute("movie", mb);
		model.addAttribute("pageNumber", pageNumber);
		
		return getPage; // movieDetailView
	}
}

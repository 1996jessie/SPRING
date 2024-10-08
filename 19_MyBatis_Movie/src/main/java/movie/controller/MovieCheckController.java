package movie.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import movie.model.MovieDao;

@Controller
public class MovieCheckController {

	@Autowired
	MovieDao movieDao;

	private final String command = "/title_check_proc.mv";

	@RequestMapping(value=command)
	@ResponseBody
	public String check(@RequestParam(value="inputtitle",required = true) String inputtitle) {

		System.out.println("controller inputtitle: "+inputtitle);

		int count = movieDao.searchTitle(inputtitle); 
		System.out.println("controller: "+count);

		PrintWriter out = null;

		if(count == 0) {//존재 안한다면
			return "YES";
		}else {
			return "NO";
		}
	}
}
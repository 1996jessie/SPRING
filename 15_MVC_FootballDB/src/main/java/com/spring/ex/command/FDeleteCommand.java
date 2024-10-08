package com.spring.ex.command;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import com.spring.ex.dao.FDao;

public class FDeleteCommand implements FCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("req");
		int num = Integer.parseInt(request.getParameter("num"));	
		FDao fdao = FDao.getInstance();
		fdao.delete(num);
		
	}

}
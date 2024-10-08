package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FUpdateFormCommand implements FCommand{

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("req");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		FDao fdao = FDao.getInstance();
		FDto fdto =  fdao.selectFootballByNum(num);
		
		request.setAttribute("fdto", fdto);
	}
}
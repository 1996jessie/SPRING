package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.MDao;

public class MDeleteCommand implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("req");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		MDao mdao = MDao.getInstance();
		mdao.delete(num);
	}
}
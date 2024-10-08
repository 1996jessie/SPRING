package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.MDao;

public class MDeleteAllCommand implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("req");
		String[] rowcheck = request.getParameterValues("rowcheck");
		
		if(rowcheck == null) {
			return;
		} else {
			MDao mdao = MDao.getInstance();
			mdao.deleteAll(rowcheck);
		}
	}
}

package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PDao;
import com.spring.ex.dto.PDto;

public class PUpdateFormCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		PDao pdao = PDao.getInstance();
		PDto pdto = new PDto();
		int num = Integer.parseInt(request.getParameter("num"));
		pdto = pdao.selectPersonByNum(num);
		
		request.setAttribute("pdto", pdto);
	}

}

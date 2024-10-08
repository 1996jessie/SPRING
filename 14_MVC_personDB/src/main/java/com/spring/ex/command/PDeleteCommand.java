package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PDao;

public class PDeleteCommand implements PCommand{
	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		PDao pdao = PDao.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		pdao.delete(num);
	}

}

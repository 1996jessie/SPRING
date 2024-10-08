package com.spring.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PDao;
import com.spring.ex.dto.PDto;

public class PListCommand implements PCommand{

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		PDao pdao = PDao.getInstance();
		ArrayList<PDto> lists = pdao.selectAll();
		
		request.setAttribute("lists", lists);
	}
}

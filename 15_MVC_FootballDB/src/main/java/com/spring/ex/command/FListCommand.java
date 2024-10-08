package com.spring.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FListCommand implements FCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		FDao fdao = FDao.getInstance();
		ArrayList<FDto> lists = fdao.selectAll();
		
		model.addAttribute("lists", lists);
	}
	
}

package com.spring.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.dao.MDao;
import com.spring.ex.dto.MartBean;

public class MListCommand implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		MDao mdao = MDao.getInstance();
		ArrayList<MartBean> lists = mdao.selectAll();
		
		model.addAttribute("lists", lists);
	}
}

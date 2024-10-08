package com.spring.ex.command;

import java.util.Map;


import org.springframework.ui.Model;

import com.spring.ex.dao.MDao;
import com.spring.ex.dto.MartBean;



public class MInsertCommand implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		MartBean mb = (MartBean)map.get("mb");
		MDao mdao = MDao.getInstance();
		mdao.insert(mb);
	}
}
